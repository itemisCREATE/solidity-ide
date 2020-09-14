//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "../solidity/zeppelin/math/SafeMath.sol";

contract AssemblyReturn {
	using SafeMath for uint256;
	
    uint256 x = 0;
	uint256 y = 0;
	
	function name() public {
		x = x.sub(y);  
		  
	} 
    
}