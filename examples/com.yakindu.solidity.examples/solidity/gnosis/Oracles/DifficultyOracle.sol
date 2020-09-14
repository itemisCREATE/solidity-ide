//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";

contract DifficultyOracle is Oracle {

    /*
     *  Events
     */
    event OutcomeAssignment(uint difficulty);

    /*
     *  Storage
     */
    uint public blockNumber;
    uint public difficulty;

	constructor (uint _blockNumber) public {
        // Block has to be in the future
        require(_blockNumber > block.number);
        blockNumber = _blockNumber;
    }

    function setOutcome()
        public
    {
        require(block.number >= blockNumber && difficulty == 0);
        difficulty = block.difficulty;
        emit OutcomeAssignment(difficulty);
    }

    function isOutcomeSet()
        public override
        returns (bool)
    {
        // Difficulty is always bigger than 0
        return difficulty > 0;
    }

    function getOutcome()
        public override
        returns (int)
    {
        return int(difficulty);
    }
}



