//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/DifficultyOracle.sol";

contract DifficultyOracleFactory {

    /*
     *  Events
     */
    event DifficultyOracleCreation(address indexed creator, DifficultyOracle difficultyOracle, uint blockNumber);

    function createDifficultyOracle(uint blockNumber)
        public
        returns (DifficultyOracle difficultyOracle)
    {
        difficultyOracle = new DifficultyOracle(blockNumber);
        DifficultyOracleCreation(msg.sender, difficultyOracle, blockNumber);
    }
}
