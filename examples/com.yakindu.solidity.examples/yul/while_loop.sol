// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function for_loop_assembly() public pure returns (uint) {
        assembly {
            let x := 0
            let i := 0
            for { } lt(i, 0x100) { } { // while(i < 0x100)
                    x := add(x, mload(i))
                    i := add(i, 0x20)
            }
        }
    }
}


