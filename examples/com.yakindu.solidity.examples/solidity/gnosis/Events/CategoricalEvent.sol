// SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6;
import "./Event.sol";

contract CategoricalEvent is Event {

	constructor (
        Token _collateralToken ,
        Oracle _oracle ,
        uint8 outcomeCount
    ) Event(_collateralToken, _oracle, outcomeCount) public {
	}

    function redeemWinnings()
        public override
        returns (uint winnings)
    {
        require(isOutcomeSet);
        winnings = outcomeTokens[uint(outcome)].balanceOf(msg.sender);
        outcomeTokens[uint(outcome)].revoke(msg.sender, winnings);
        require(collateralToken.transfer(msg.sender, winnings));
        WinningsRedemption(msg.sender, winnings);
    }

    function getEventHash()
        public view override
        returns (bytes32)
    {
        return keccak256(abi.encodePacked(collateralToken, oracle, outcomeTokens.length));
    }
}



