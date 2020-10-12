//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;
contract Incrementer {

    address payable creator;
    uint iteration;

	constructor () public {
        creator = msg.sender; 
        iteration = 0;
    }

    function increment() public 
    {
        iteration = iteration + 1;
    }
    
    function getIteration() view public returns (uint) 
    {
        return iteration;
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





