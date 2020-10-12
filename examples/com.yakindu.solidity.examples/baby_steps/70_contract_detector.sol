// Given an address hash, detect whether it's a contract-type address or a normal one

/***
 *     _    _  ___  ______ _   _ _____ _   _ _____ 
 *    | |  | |/ _ \ | ___ \ \ | |_   _| \ | |  __ \
 *    | |  | / /_\ \| |_/ /  \| | | | |  \| | |  \/
 *    | |/\| |  _  ||    /| . ` | | | | . ` | | __ 
 *    \  /\  / | | || |\ \| |\  |_| |_| |\  | |_\ \
 *     \/  \/\_| |_/\_| \_\_| \_/\___/\_| \_/\____/
 *                                                 
 *   This contract DOES NOT WORK. It is not currently possible to 
 *   determine whether an address hash is a contract or normal address
 *   from Solidity. - fivedogit 9/14/2015                                              
 */

//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract ContractDetector {

    address payable creator;
    string contract_or_normal = "not checked";

	constructor () public {
        creator = msg.sender;
    }
    
    function testContractOrNormal(address inc_addr) public
    {
        (bool success,) = inc_addr.call("");
    	if(success)
    		contract_or_normal = "normal";
    	else
    		contract_or_normal = "contract";
    }
    
    function getContractOrNormal() view public returns (string memory)
    {
    	return contract_or_normal;
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


