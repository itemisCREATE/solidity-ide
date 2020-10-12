/***
 *     _    _  ___  ______ _   _ _____ _   _ _____ 
 *    | |  | |/ _ \ | ___ \ \ | |_   _| \ | |  __ \
 *    | |  | / /_\ \| |_/ /  \| | | | |  \| | |  \/
 *    | |/\| |  _  ||    /| . ` | | | | . ` | | __ 
 *    \  /\  / | | || |\ \| |\  |_| |_| |\  | |_\ \
 *     \/  \/\_| |_/\_| \_\_| \_/\___/\_| \_/\____/
 *                                                 
 *   This contract DOES NOT WORK. Dynamically sized types cannot be returned (incl. "string" and "bytes").                                      
 */


//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract Descriptor {
    function getDescription() pure public returns (string memory){
        string memory somevar;
		somevar = "tencharsme"; 
		return somevar;
    }
}

contract StringPasser {
    address payable creator;
    
    uint8 mapsize = 9;
    Tile[9][9] tiles; 

    struct Tile 
    {
        address owner;
        uint8 elevation;
        Descriptor descriptor;
    }

	constructor (uint8[] memory incmap) public {
        creator = msg.sender;
        uint counter = 0;
        Descriptor nothing;
        for(uint8 y = 0; y < mapsize; y++)
       	{
            for(uint8 x = 0; x < mapsize; x++)
           	{
                tiles[x][y].descriptor = nothing;
           		tiles[x][y].elevation = incmap[counter];
            }
        }
    }  
   /*** 
    * 4. get Description of a tile at x,y
    ***/ 
    function getTileDescription(uint8 x, uint8 y) public view
    {
        Descriptor desc = tiles[x][y].descriptor;       // get the descriptor for this tile
    	string memory anothervar = desc.getDescription();  // get the description from the descriptor
    	
    	// TODO validate the description
    	// TODO convert it to JSON
    	// save it to a variable for constant retrieval elsewhere
    	
    	return;
    }
    
    /**********
     Standard kill() function to recover funds 
     **********/
    function kill() public
    {
        if (msg.sender == creator)
        {
            selfdestruct(creator); // kills this contract and sends remaining funds back to creator
        }
    }
}




