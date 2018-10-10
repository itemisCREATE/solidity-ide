pragma solidity ^0.5.0;

contract keccak256Test {
    constructor () public{
    }

    function test(bytes a) internal pure{
        bytes32 b = keccak256(a);
    }
}