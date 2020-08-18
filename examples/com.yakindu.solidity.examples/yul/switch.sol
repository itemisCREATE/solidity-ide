// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function switch_assembly(uint n, uint value) public pure returns (uint) {

        assembly {
            let x := 0
            switch
            calldataload(4)
            case
            0
            {
                x := calldataload(0x24)
            }
            default
            {
                x := calldataload(0x44)
            }
            sstore(0, div(x, 2))
        }
    }
}


