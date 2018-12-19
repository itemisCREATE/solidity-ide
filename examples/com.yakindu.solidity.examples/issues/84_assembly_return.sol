pragma solidity ^0.5.1;

contract AssemblyReturn {
    
    address t;

    function(){
    assembly { 
            let _target := t
            calldatacopy(0x0, 0x0, calldatasize) 
            let retval := delegatecall(gas, _target, 0x0, calldatasize, 0x0, 0)
            let returnsize := returndatasize
            returndatacopy(0x0, 0x0, returnsize)
            switch retval case 0 {revert(0, 0)} default {return (0, returnsize)}
        }  
    }
}
