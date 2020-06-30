pragma solidity 0.6.10;

contract keccak256Test {
    constructor () public{
    }

    function test(bytes a) internal pure{
        bytes32 b = keccak256(a);
    }
}