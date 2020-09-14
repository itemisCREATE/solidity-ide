// SPDX-License-Identifier: MIT
pragma solidity ^0.6.10;

contract Greeter          
{
    // At first, an empty "address"-type variable of the name "creator". Will be set in the constructor.
    address payable creator;     
    // At first, an empty "string"-type variable of the name "greeting". Will be set in constructor and can be changed.
    string greeting;

	constructor (string memory _greeting) public {
    	creator = msg.sender;
        greeting = _greeting; 
    }

    function greet() view public returns (string memory)          
    {
        return greeting;
    }
   
    // this doesn't have anything to do with the act of greeting
    // just demonstrating return of some global variable
    function getBlockNumber() view public returns (uint) 
    {													
        return block.number;
    }
    
    function setGreeting(string memory _newgreeting) public 
    {
        greeting = _newgreeting;
    }
    
     /**********
     Standard kill() function to recover funds 
     **********/
    
    function kill() public 
    { 
        if (msg.sender == creator) 
        { 
            // only allow this action if the account sending the signal is the creator
            // kills this contract and sends remaining funds back to creator
            selfdestruct(creator);       
		}    
    }

}






