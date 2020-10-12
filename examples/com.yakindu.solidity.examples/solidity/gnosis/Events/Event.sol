//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6;
import "../Tokens/Token.sol";
import "../Tokens/OutcomeToken.sol";
import "../Oracles/Oracle.sol";

abstract contract Event {

    event OutcomeTokenCreation(OutcomeToken outcomeToken, uint8 index);
    event OutcomeTokenSetIssuance(address indexed buyer, uint collateralTokenCount);
    event OutcomeTokenSetRevocation(address indexed seller, uint outcomeTokenCount);
    event OutcomeAssignment(int outcome);
    event WinningsRedemption(address indexed receiver, uint winnings);

    Token public collateralToken;
    Oracle public oracle;
    bool public isOutcomeSet;
    int public outcome;
    OutcomeToken[] public outcomeTokens;

	constructor (Token _collateralToken , Oracle _oracle , uint8 outcomeCount) public {
        require(address(_collateralToken) != address(0) && address(_oracle) != address(0) && outcomeCount >= 2);
        collateralToken = _collateralToken;
        oracle = _oracle;
        for (uint8 i = 0; i < outcomeCount; i++) {
            OutcomeToken outcomeToken = new OutcomeToken();
            outcomeTokens.push(outcomeToken);
            OutcomeTokenCreation(outcomeToken, i);
        }
    }
    
    function buyAllOutcomes(uint collateralTokenCount)
        public
    {
        require(collateralToken.transferFrom(msg.sender, address(this), collateralTokenCount));
        for (uint8 i = 0; i < outcomeTokens.length; i++)
            outcomeTokens[i].issue(msg.sender, collateralTokenCount);
        OutcomeTokenSetIssuance(msg.sender, collateralTokenCount);
    }

    function sellAllOutcomes(uint outcomeTokenCount)
        public
    {
        for (uint8 i = 0; i < outcomeTokens.length; i++)
            outcomeTokens[i].revoke(msg.sender, outcomeTokenCount);
        require(collateralToken.transfer(msg.sender, outcomeTokenCount));
        OutcomeTokenSetRevocation(msg.sender, outcomeTokenCount);
    }

    function setOutcome()
        public
    {
        require(!isOutcomeSet && oracle.isOutcomeSet());
        outcome = oracle.getOutcome();
        isOutcomeSet = true;
        OutcomeAssignment(outcome);
    }

    function getOutcomeCount()
        public view
        returns (uint8)
    {
        return uint8(outcomeTokens.length);
    }

    function getOutcomeTokens()
        public view
        returns (OutcomeToken[] memory)
    {
        return outcomeTokens;
    }

    function getOutcomeTokenDistribution(address owner)
        public view
        returns (uint[] memory outcomeTokenDistribution)
    {
        outcomeTokenDistribution = new uint[](outcomeTokens.length);
        for (uint8 i = 0; i < outcomeTokenDistribution.length; i++)
            outcomeTokenDistribution[i] = outcomeTokens[i].balanceOf(owner);
    }

    function getEventHash() public view virtual returns (bytes32);

    function redeemWinnings() public virtual returns (uint);
}



