//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;

contract Pong {

    address payable creator;
    int8 constructortouches = 0;
    int8 namelesstouches = 0;

    constructor () public {
        creator = msg.sender;
        constructortouches = constructortouches + 1;
    }
	
	/*********
	 Step 4. Accept generic transaction (send(), hopefully)
	 *********/	
	fallback () external {
        namelesstouches = namelesstouches + 1;
        return;
    }

// ----------------------------------------------------------------------------------------------------------------------------------------
    function getBalance() public view returns (uint) {
        return address(this).balance;
    }

    /*********
     * 	 touches getters
     *********/
    function getConstructorTouches() public view returns (int8) {
        return constructortouches;
    }

    function getNamelessTouches() public view returns (int8) {
        return namelesstouches;
    }

    /****
     *  For double-checking this contract's address
     ****/
    function getAddress() view public returns (address) {
        return address(this);
    }

    /**********
     *  Standard kill() function to recover funds 
     **********/
    function kill() public {
        if (msg.sender == creator)
            selfdestruct(creator); // kills this contract and sends remaining funds back to creator
    }
}


