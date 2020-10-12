//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract AssemblyReturn {
    
    address t;

    fallback() external {
    assembly { 
            let _target := t_slot
            calldatacopy(0x0, 0x0, calldatasize()) 
            let retval := delegatecall(gas(), _target, 0x0, calldatasize(), 0x0, 0)
            let returnsize := returndatasize()
            returndatacopy(0x0, 0x0, returnsize)
            switch retval case 0 {revert(0, 0)} default {return (0, returnsize)}
        }  
    }
}
