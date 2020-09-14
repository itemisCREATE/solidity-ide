//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;
contract creatorBalanceChecker {

    address payable creator;
    uint creatorbalance;

	constructor () public {
        creator = msg.sender; 								 // msg is a global variable
        creatorbalance = creator.balance;
    }

	function getContractAddress() view public returns (address) 
	{
		return address(this);
	}

	function getCreatorBalance() view public returns (uint)     // Will return the creator's balance AT THE TIME THIS CONTRACT WAS CREATED
	{
        return creatorbalance;
    }
    
    function getCreatorDotBalance() view public returns (uint)  // Will return creator's balance NOW
    {
        return creator.balance;
    }
    
    /**********
     Standard kill() function to recover funds 
     **********/
    
    function kill() public
    { 
        if (msg.sender == creator)
            selfdestruct(creator);  // kills this contract and sends remaining funds back to creator
    }
}





