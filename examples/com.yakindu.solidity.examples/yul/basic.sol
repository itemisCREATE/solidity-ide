// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor() public{
        creator = msg.sender;
    }

    // TODO Add functions

    function addition(uint x, uint y) public pure returns (uint) {
        assembly {
          let result := add(x, y)   // x + y
          mstore(0x0, result)       // store result in memory
          return(0x0, 32)           // return 32 bytes from memory 
      	}
    }
}
