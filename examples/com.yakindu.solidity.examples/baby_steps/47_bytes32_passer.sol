// In addition to testing contract-to-contract variable passing, 
// this contract tests assignment of a string to a bytes32 type. 
// the result of "savedvar" is "0x1a09254100000000000000000000000000000000000000000000000000000000"
// but I don't currently understand why, and would like to know how to 
// convert that hex back into "tencharsme"

//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract Descriptor {
    
	function getDescription() pure public returns (bytes32){	
		bytes32 somevar;
		somevar = "tencharsme"; 
		return somevar;
	}
}

contract Bytes32Passer {

    address payable creator;
    bytes savedbytes;
    bytes32 savedvar;
    string savedstring;
    Descriptor descriptor;

	constructor () public {
        creator = msg.sender;
    }
    
    function getDescription() public
    {
    	savedvar = descriptor.getDescription();  // get the description from the descriptor
    	uint8 x = 0;
    	while(x < 32)
    	{
    		savedbytes[x] = savedvar[x];
    		x++;
    	}	
    	savedstring = string(savedbytes); // convert bytes to string
    	return; 
    }
    
    function getSavedVar() view public returns (bytes32)
    {
    	return savedvar;
    }
    
    function getSavedBytes() view public returns (bytes memory)
    {
    	return savedbytes;
    }
    
    function getSavedString() view public returns (string memory)
    {
    	return savedstring;
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



