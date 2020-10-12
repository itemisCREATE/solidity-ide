//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Markets/Market.sol";
import "../Tokens/Token.sol";
import "../Events/Event.sol";
import "../MarketMakers/MarketMaker.sol";

contract StandardMarket is Market {
    using Math for *;

    /*
     *  Constants
     */
    uint24 public constant FEE_RANGE = 1000000; // 100%

    /*
     *  Modifiers
     */
    modifier isCreator () {
        require(msg.sender == creator);
        _;
    }

    modifier atStage(Stages _stage) {
        require(stage == _stage);
        _;
    }

	constructor (address _creator , Event _eventContract , MarketMaker _marketMaker , uint24 _fee) public {
        require(address(_eventContract) != address(0) && address(_marketMaker) != address(0) && _fee < FEE_RANGE);
        creator = _creator;
        createdAtBlock = block.number;
        eventContract = _eventContract;
        netOutcomeTokensSold = new int[](eventContract.getOutcomeCount());
        fee = _fee;
        marketMaker = _marketMaker;
        stage = Stages.MarketCreated;
    }

    function fund(uint _funding)
        public override
        isCreator
        atStage(Stages.MarketCreated)
    {
        // Request collateral tokens and allow event contract to transfer them to buy all outcomes
        require(   eventContract.collateralToken().transferFrom(msg.sender, address(this), _funding)
                && eventContract.collateralToken().approve(address(eventContract), _funding));
        eventContract.buyAllOutcomes(_funding);
        funding = _funding;
        stage = Stages.MarketFunded;
        MarketFunding(funding);
    }

    /// @dev Allows market creator to close the markets by transferring all remaining outcome tokens to the creator
    function close()
        public override
        isCreator
        atStage(Stages.MarketFunded)
    {
        uint8 outcomeCount = eventContract.getOutcomeCount();
        for (uint8 i = 0; i < outcomeCount; i++)
            require(eventContract.outcomeTokens(i).transfer(creator, eventContract.outcomeTokens(i).balanceOf(address(this))));
        stage = Stages.MarketClosed;
        MarketClosing();
    }

    function withdrawFees()
        public override
        isCreator
        returns (uint fees)
    {
        fees = eventContract.collateralToken().balanceOf(address(this));
        require(eventContract.collateralToken().transfer(creator, fees));
        FeeWithdrawal(fees);
    }

    function buy(uint8 outcomeTokenIndex, uint outcomeTokenCount, uint maxCost)
        public override
        atStage(Stages.MarketFunded)
        returns (uint cost)
    {
        // Calculate cost to buy outcome tokens
        uint outcomeTokenCost = marketMaker.calcCost(this, outcomeTokenIndex, outcomeTokenCount);
        // Calculate fees charged by market
        uint fees = calcMarketFee(outcomeTokenCost);
        cost = outcomeTokenCost.add(fees);
        // Check cost doesn't exceed max cost
        require(cost > 0 && cost <= maxCost);
        // Transfer tokens to markets contract and buy all outcomes
        require(   eventContract.collateralToken().transferFrom(msg.sender, address(this), cost)
                && eventContract.collateralToken().approve(address(eventContract), outcomeTokenCost));
        // Buy all outcomes
        eventContract.buyAllOutcomes(outcomeTokenCost);
        // Transfer outcome tokens to buyer
        require(eventContract.outcomeTokens(outcomeTokenIndex).transfer(msg.sender, outcomeTokenCount));
        // Add outcome token count to market maker net balance
        require(int(outcomeTokenCount) >= 0);
        netOutcomeTokensSold[outcomeTokenIndex] = netOutcomeTokensSold[outcomeTokenIndex].add(int(outcomeTokenCount));
        OutcomeTokenPurchase(msg.sender, outcomeTokenIndex, outcomeTokenCount, cost);
    }

    function sell(uint8 outcomeTokenIndex, uint outcomeTokenCount, uint minProfit)
        public override
        atStage(Stages.MarketFunded)
        returns (uint profit)
    {
        // Calculate profit for selling outcome tokens
        uint outcomeTokenProfit = marketMaker.calcProfit(this, outcomeTokenIndex, outcomeTokenCount);
        // Calculate fee charged by market
        uint fees = calcMarketFee(outcomeTokenProfit);
        profit = outcomeTokenProfit.sub(fees);
        // Check profit is not too low
        require(profit > 0 && profit >= minProfit);
        // Transfer outcome tokens to markets contract to sell all outcomes
        require(eventContract.outcomeTokens(outcomeTokenIndex).transferFrom(msg.sender, address(this), outcomeTokenCount));
        // Sell all outcomes
        eventContract.sellAllOutcomes(outcomeTokenProfit);
        // Transfer profit to seller
        require(eventContract.collateralToken().transfer(msg.sender, profit));
        // Subtract outcome token count from market maker net balance
        require(int(outcomeTokenCount) >= 0);
        netOutcomeTokensSold[outcomeTokenIndex] = netOutcomeTokensSold[outcomeTokenIndex].sub(int(outcomeTokenCount));
        OutcomeTokenSale(msg.sender, outcomeTokenIndex, outcomeTokenCount, profit);
    }

    function shortSell(uint8 outcomeTokenIndex, uint outcomeTokenCount, uint minProfit)
        public override
        returns (uint cost)
    {
        // Buy all outcomes
        require(   eventContract.collateralToken().transferFrom(msg.sender, address(this), outcomeTokenCount)
                && eventContract.collateralToken().approve(address(eventContract), outcomeTokenCount));
        eventContract.buyAllOutcomes(outcomeTokenCount);
        // Short sell selected outcome
        eventContract.outcomeTokens(outcomeTokenIndex).approve(address(this), outcomeTokenCount);
        uint profit = this.sell(outcomeTokenIndex, outcomeTokenCount, minProfit);
        cost = outcomeTokenCount - profit;
        // Transfer outcome tokens to buyer
        uint8 outcomeCount = eventContract.getOutcomeCount();
        for (uint8 i = 0; i < outcomeCount; i++)
            if (i != outcomeTokenIndex)
                require(eventContract.outcomeTokens(i).transfer(msg.sender, outcomeTokenCount));
        // Send change back to buyer
        require(eventContract.collateralToken().transfer(msg.sender, profit));
        OutcomeTokenShortSale(msg.sender, outcomeTokenIndex, outcomeTokenCount, cost);
    }

    function calcMarketFee(uint outcomeTokenCost)
        public override view
        returns (uint)
    {
        return outcomeTokenCost * fee / FEE_RANGE;
    }
}



