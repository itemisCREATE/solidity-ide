//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract MyContract {
    address payable creator;

	constructor () public {
        creator = msg.sender;
    }

    // TODO Add functions

    /**********
     Standard kill() function to recover funds 
     **********/
    function kill() public {
        if (msg.sender == creator) {
            selfdestruct(creator); // kills this contract and sends remaining funds back to creator
        }
    }
}



