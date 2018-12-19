pragma solidity ^0.5.1;

import "../solidity/zeppelin/math/SafeMath.sol";

contract AssemblyReturn {
	using SafeMath for uint256;
	
    uint256 x = 0;
	uint256 y = 0;
	
	function name() {
		x = x.sub(y);  
		  
	} 
    
}