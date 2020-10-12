//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/MajorityOracle.sol";


/// @title Majority oracle factory contract - Allows to create majority oracle contracts
/// @author Stefan George - <stefan@gnosis.pm>
contract MajorityOracleFactory {

    /*
     *  Events
     */
    event MajorityOracleCreation(address indexed creator, MajorityOracle majorityOracle, Oracle[] oracles);

    function createMajorityOracle(Oracle[] memory oracles)
        public
        returns (MajorityOracle majorityOracle)
    {
        majorityOracle = new MajorityOracle(oracles);
        emit MajorityOracleCreation(msg.sender, majorityOracle, oracles);
    }
}
