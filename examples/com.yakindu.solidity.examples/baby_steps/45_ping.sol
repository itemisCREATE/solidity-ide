//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;

contract PongvalRetriever {
 	int8 pongval_tx_retrieval_attempted = 0;
	function getPongvalTransactional() public returns (int8){	// tells Ping how to interact with Pong.
		pongval_tx_retrieval_attempted = -1;
		return pongval_tx_retrieval_attempted;
	}
}

contract Ping is PongvalRetriever {

 	int8 pongval;
	PongvalRetriever pvr;
    address payable creator;

	constructor (PongvalRetriever _pongAddress) public {
        creator = msg.sender; 	
        pongval = -1;							
        pvr = _pongAddress;
    }

	/*********
     Step 3: Transactionally retrieve pongval from Pong. 
     *********/

	function getPongvalRemote() public 
	{
		pongval = pvr.getPongvalTransactional();
	}
	
	/*********
     Step 5: Get pongval (which was previously retrieved from Pong via transaction)
     *********/
     
    function getPongvalConstant() view public returns (int8)
    {
    	return pongval;
    }
	
  
// -----------------------------------------------------------------------------------------------------------------	
	
	/*********
     Functions to get and set pongAddress just in case
     *********/
    
    function setPongAddress(PongvalRetriever _pongAddress) public
	{
		pvr = _pongAddress;
	}
	
	function getPongAddress() view public returns (address)
	{
		return address(pvr);
	}
    
    /****
	 For double-checking this contract's address
	 ****/
	function getAddress() public view returns (address)
	{
		return address(this);
	}
    
    /*********
     Standard kill() function to recover funds 
     *********/
    
    function kill() public
    { 
        if (msg.sender == creator)
            selfdestruct(creator);  // kills this contract and sends remaining funds back to creator
    }
}




// See Pong for deployment/use. 
