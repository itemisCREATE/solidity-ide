// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function addition(uint x, uint y) pure public {
        assembly {

            let alpha := 3 // x is visible everywhere
            // Scope 1           
            {
                let beta := x // ok
            } // y is "deallocated" here
            // Scope 2    
            {
                let z := y // Error
            } // x is "deallocated" here
        }
    }
}


