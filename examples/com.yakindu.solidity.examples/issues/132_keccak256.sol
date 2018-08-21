pragma solidity ^0.4.23;


contract MyContract {
    constructor () public{
    }

    function test() internal pure{
        bytes a;
        bytes32 b = keccak256(a);
    }
}