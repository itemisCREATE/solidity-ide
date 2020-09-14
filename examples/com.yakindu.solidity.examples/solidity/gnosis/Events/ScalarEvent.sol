//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Events/Event.sol";

contract ScalarEvent is Event {
    using Math for *;

    uint8 public constant SHORT = 0;
    uint8 public constant LONG = 1;
    uint24 public constant OUTCOME_RANGE = 1000000;

    int public lowerBound;
    int public upperBound;

    constructor (Token _collateralToken, Oracle _oracle, int _lowerBound, int _upperBound) public Event(_collateralToken, _oracle, 2) {
        require(_upperBound > _lowerBound);
        lowerBound = _lowerBound;
        upperBound = _upperBound;
    }

    function redeemWinnings() public override
        returns (uint winnings) {
        require(isOutcomeSet);
        uint24 convertedWinningOutcome;
        if (outcome < lowerBound)
            convertedWinningOutcome = 0;
        else if (outcome > upperBound)
            convertedWinningOutcome = OUTCOME_RANGE;
        else convertedWinningOutcome = uint24(OUTCOME_RANGE * (outcome - lowerBound) / (upperBound - lowerBound));
        uint factorShort = OUTCOME_RANGE - convertedWinningOutcome;
        uint factorLong = OUTCOME_RANGE - factorShort;
        uint shortOutcomeTokenCount = outcomeTokens[SHORT].balanceOf(msg.sender);
        uint longOutcomeTokenCount = outcomeTokens[LONG].balanceOf(msg.sender);
        winnings = shortOutcomeTokenCount.mul(factorShort).add(longOutcomeTokenCount.mul(factorLong)) / OUTCOME_RANGE;
        outcomeTokens[SHORT].revoke(msg.sender, shortOutcomeTokenCount);
        outcomeTokens[LONG].revoke(msg.sender, longOutcomeTokenCount);
        require(collateralToken.transfer(msg.sender, winnings));
        WinningsRedemption(msg.sender, winnings);
    }

    function getEventHash() public view override
        returns (bytes32) {
        return keccak256(abi.encodePacked(collateralToken, oracle, lowerBound, upperBound));
    }
}


