// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function for_loop_assembly(uint n, uint value) public pure returns (uint) {

        assembly {

            for { let i := 0 } lt(i, n) { i := add(i, 1) } {
                value := mul(2, value)
            }
            mstore(0x0, value)
            return(0x0, 32)
        }
    }
}


