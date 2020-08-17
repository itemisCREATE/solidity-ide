// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function multiassignment(uint n, uint value) public pure returns (uint) {

        assembly {    
			function f() -> a, b {}
			let c, d := f()
		}
    }
}


