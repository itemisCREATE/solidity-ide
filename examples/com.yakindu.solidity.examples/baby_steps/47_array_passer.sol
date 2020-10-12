//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "./mortal.sol";

// contract Descriptor {
// 	function getDescription() constant returns (uint16[3]){	
// 		uint16[3] somevar;
// 		return somevar;
// 	}
// }
contract Coin
{
    struct Bank {
    address owner;
    uint balance;
}
}

contract ArrayPasser is mortal {
    address creator;
    uint8 mapsize = 3;
    Tile[3][3] tiles; 

    struct Tile 
    {
        uint8 elevation;
    // Descriptor descriptor;
    }

	constructor (uint8[9] memory incmap) public {
        creator = msg.sender;
        uint8 counter = 0;
        for(uint8 y = 0; y < mapsize; y++)
       	{
            for(uint8 x = 0; x < mapsize; x++)
           	{
                tiles[x][y].elevation = incmap[counter]; 
           		counter = counter + 1;
            }
        }
    }

    /***
     * 4. After contract mined, check the map elevations
     ***/
    function getElevations() view public returns (uint8[3][3] memory){
        uint8[3][3] memory elevations;
        for(uint8 y = 0; y < mapsize; y++)
        {
            for(uint8 x = 0; x < mapsize; x++)
        	{
                elevations[x][y] = tiles[x][y].elevation;
            }
        }
        return elevations;
    }
}




