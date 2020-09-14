// This contract creates a 9x9 map of Tile objects. 
// Each tile has an elevation value (as well as an owner and descriptorContract which aren't used here)
// 
// In the constructor, the elevations are set to standard values via for loops.

//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
contract StructAndFor {

    address payable creator;
    uint8 mapsize = 9;
    Tile[9][9] tiles; 
    
    struct Tile 
    {
        address owner;
        address descriptorContract;
        uint8 elevation;
    }

	constructor () public {
        creator = msg.sender;
        for(uint8 y = 0; y < mapsize; y++)
    	{
        	for(uint8 x = 0; x < mapsize; x++)
        	{
        		tiles[x][y].elevation = mapsize*y + x; // row 0: 0, 1, 2, 3, 4...   row 1: 9, 10, 11, 12
        	}	
        }	
    }
    
    function getElevation(uint8 x, uint8 y) view public returns (uint8)
    {
    	return tiles[x][y].elevation;
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


