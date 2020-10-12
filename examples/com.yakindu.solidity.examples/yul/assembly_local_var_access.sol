// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function assembly_local_var_access() public pure {
        uint b = 5;
        assembly { // defined inside  an assembly block
            let x := add(2, 3)
            let y := 10
            let z := add(x, y)
        }
        assembly { // defined outside an assembly block
            let x := add(2, 3)
            let y := mul(x, b)
        }
    }
}


