/***
 *     _    _  ___  ______ _   _ _____ _   _ _____ 
 *    | |  | |/ _ \ | ___ \ \ | |_   _| \ | |  __ \
 *    | |  | / /_\ \| |_/ /  \| | | | |  \| | |  \/
 *    | |/\| |  _  ||    /| . ` | | | | . ` | | __ 
 *    \  /\  / | | || |\ \| |\  |_| |_| |\  | |_\ \
 *     \/  \/\_| |_/\_| \_\_| \_/\___/\_| \_/\____/
 *                                                 
 *   This contract DOES NOT WORK at the moment. 9/22/2015                                     
 */

// 1. Deploy Pong .
// 2. Deploy Ping, giving it the address of Pong.
// 3. Call Ping.touchPong() using a <pongaddress>.send()
// 4. ... which does... something ...

//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract Ping {

	address payable pvr;
    address payable creator;
    int8 sendval = -2;

	constructor (address payable _pongAddress) public {
        creator = msg.sender; 	
        pvr = _pongAddress;
    }

	/*********
     Step 3: Touch pong with a 3,000,000 wei "send" call and see what happens. 
     *********/

	function send3MilWeiToPong() public 
	{
		sendval = -1;  // at least we reached this function
		bool retval = false;
		retval = pvr.send(3000000); // send 3,000,000 wei to pong // trying to determine what exactly happens here.
		if(retval)
			sendval = 1; // success!
		else 
			sendval = 0; // failure!
	}	
  
// -----------------------------------------------------------------------------------------------------------------	
	
	function getBalance() public view returns (uint)
	{
		return address(this).balance;
	}
	

	function getSendVal() public view returns (int8)
	{
		return sendval;
	}
	
	/*********
     Functions to get and set pongAddress just in case
     *********/
    
    function setPongAddress(address payable _pongAddress) public
	{
		pvr = _pongAddress;
	}
	
	function getPongAddress() view public returns (address)
	{
		return pvr;
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



