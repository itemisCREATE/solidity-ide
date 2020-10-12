//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/SignedMessageOracle.sol";


contract SignedMessageOracleFactory {

    /*
     *  Events
     */
    event SignedMessageOracleCreation(address indexed creator, SignedMessageOracle signedMessageOracle, address oracle);

    /*
     *  Public functions
     */
    function createSignedMessageOracle(bytes32 descriptionHash, uint8 v, bytes32 r, bytes32 s)
        public
        returns (SignedMessageOracle signedMessageOracle)
    {
        signedMessageOracle = new SignedMessageOracle(descriptionHash, v, r, s);
        address oracle = ecrecover(descriptionHash, v, r, s);
        SignedMessageOracleCreation(msg.sender, signedMessageOracle, oracle);
    }
}
