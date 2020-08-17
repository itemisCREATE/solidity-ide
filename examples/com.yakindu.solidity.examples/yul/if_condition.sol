// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function if_condition_assembly(uint n, uint value) public pure returns (uint) {
         
     	assembly {
    		if slt(x, 0) { x := sub(0, x) }  // Ok
            
    		if eq(value, 0) { revert(0, 0) }    // Error, curly braces needed
		}
	}
}


