
//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract ReplicatorB {

    address payable creator;
    uint blockCreatedOn;

    function Replicator() public 
    {
        creator = msg.sender;
       // next = new ReplicatorA();    // Replicator B can't instantiate A because it doesn't yet know about A
       								   // At the time of this writing (Sept 2015), It's impossible to create cyclical relationships
       								   // either with self-replicating contracts or A-B-A-B 
        blockCreatedOn = block.number;
    }
	
	function getBlockCreatedOn() view public returns (uint)
	{
		return blockCreatedOn;
	}
	
    /**********
     Standard kill() function to recover funds 
     **********/
    
    function kill() public
    { 
        if (msg.sender == creator)
        {
            selfdestruct(creator);  // kills this contract and sends remaining funds back to creator
        }
    }
}

contract ReplicatorA {

    address payable creator;
	address baddress;
	uint blockCreatedOn;

    function Replicator() public 
    {
        creator = msg.sender;
        baddress = address(new ReplicatorB());		 // This works just fine because A already knows about B
        blockCreatedOn = block.number;
    }

	function getBAddress() view public returns (address)
	{
		return baddress;
	}
	
	function getBlockCreatedOn() view public returns (uint)
	{
		return blockCreatedOn;
	}
	
    /**********
     Standard kill() function to recover funds 
     **********/
    
    function kill() public
    { 
        if (msg.sender == creator)
        {
            selfdestruct(creator);  // kills this contract and sends remaining funds back to creator
        }
    }
}
