//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "./mortal.sol";

contract MsgValueToBytes20 is mortal {

	uint initialval;
	uint80 uint80val; 
	bytes20 finalval;
    
    function convertMsgValueToBytes20() payable public 
    {
    	initialval = msg.value;
    	if(msg.value > 0 || msg.value < 1208925819614629174706176) // 1 wei up to (2^80 - 1) wei is the valid uint80 range
    	{
    		uint80val = uint80(msg.value);
//    		finalval = bytes20(uint80val);
    	}
    }
    
    function getInitialval() view public returns (uint)
    {
    	return initialval;
    }
    
    function getUint80val() view public returns (uint80)
    {
    	return uint80val;
    }
    
    function getFinalval() view public returns (bytes20)
    {
    	return finalval;
    }
    
}


/*

msgvaluetobytes20.convertMsgValueToBytes20.sendTransaction({from:eth.coinbase,value:web3.toWei(.001,"ether")});

> msgvaluetobytes20.getInitialval();
10000
> msgvaluetobytes20.getUint80val();
10000
> msgvaluetobytes20.getFinalval();
"0x0000000000000000000000000000000000002710"

*/