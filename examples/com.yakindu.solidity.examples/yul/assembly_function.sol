// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9;

contract MyContract {
    address creator;

    constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions
    function assembly_function(uint n, uint value) public pure returns (uint) {

        assembly {
    
		    function allocate(length) -> pos {
		        pos := mload(0x40)
		        mstore(0x40, add(pos, length))
		    }
		    let free_memory_pointer := allocate(64)
		}
    }
}


