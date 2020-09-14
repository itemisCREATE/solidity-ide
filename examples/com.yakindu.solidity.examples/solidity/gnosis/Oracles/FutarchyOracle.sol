//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";
import "../Events/EventFactory.sol";
import "../Markets/MarketFactory.sol";

contract FutarchyOracle is Oracle {
    using Math for *;

    /*
     *  Events
     */
    event FutarchyFunding(uint funding);
    event FutarchyClosing();
    event OutcomeAssignment(uint winningMarketIndex);

    /*
     *  Constants
     */
    uint8 public constant LONG = 1;

    /*
     *  Storage
     */
    address creator;
    Market[] public markets;
    CategoricalEvent public categoricalEvent;
    uint public deadline;
    uint public winningMarketIndex;
    bool public isSet;

    /*
     *  Modifiers
     */
    modifier isCreator () {
        // Only creator is allowed to proceed
        require(msg.sender == creator);
        _;
    }

	constructor (
        address _creator ,
        EventFactory eventFactory ,
        Token collateralToken ,
        Oracle oracle ,
        uint8 outcomeCount ,
        int lowerBound ,
        int upperBound ,
        MarketFactory marketFactory ,
        MarketMaker marketMaker ,
        uint24 fee ,
        uint _deadline
    ) public {
        require(_deadline > now);
        categoricalEvent = eventFactory.createCategoricalEvent(collateralToken, this, outcomeCount);
        for (uint8 i = 0; i < categoricalEvent.getOutcomeCount(); i++) {
            ScalarEvent scalarEvent = eventFactory.createScalarEvent(
                categoricalEvent.outcomeTokens(i),
                oracle,
                lowerBound,
                upperBound
            );
            markets.push(marketFactory.createMarket(scalarEvent, marketMaker, fee));
        }
        creator = _creator;
        deadline = _deadline;
    }
    
    function fund(uint funding)
        public
        isCreator
    {
        require(   categoricalEvent.collateralToken().transferFrom(creator, address(this), funding)
                && categoricalEvent.collateralToken().approve(address(categoricalEvent), funding));
        categoricalEvent.buyAllOutcomes(funding);
        for (uint8 i = 0; i < markets.length; i++) {
            Market market = markets[i];
            // Approve funding for market
            require(market.eventContract().collateralToken().approve(address(market), funding));
            market.fund(funding);
        }
        FutarchyFunding(funding);
    }

    function close()
        public
        isCreator
    {
        Market market = markets[uint(getOutcome())];
        require(categoricalEvent.isOutcomeSet() && market.eventContract().isOutcomeSet());
        market.close();
        market.eventContract().redeemWinnings();
        market.withdrawFees();
        categoricalEvent.redeemWinnings();
        require(categoricalEvent.collateralToken().transfer(creator, categoricalEvent.collateralToken().balanceOf(address(this))));
        FutarchyClosing();
    }

    function setOutcome()
        public
    {
        require(!isSet && deadline <= now);
        uint highestMarginalPrice = markets[0].marketMaker().calcMarginalPrice(markets[0], LONG);
        uint highestIndex = 0;
        for (uint8 i = 1; i < markets.length; i++) {
            uint marginalPrice = markets[i].marketMaker().calcMarginalPrice(markets[i], LONG);
            if (marginalPrice > highestMarginalPrice) {
                highestMarginalPrice = marginalPrice;
                highestIndex = i;
            }
        }
        winningMarketIndex = highestIndex;
        isSet = true;
        OutcomeAssignment(winningMarketIndex);
    }

    function isOutcomeSet()
        public override
        returns (bool)
    {
        return isSet;
    }

    function getOutcome()
        public override
        returns (int)
    {
        return int(winningMarketIndex);
    }
}



