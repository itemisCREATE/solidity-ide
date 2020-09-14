//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract MappingType {

    struct STRUCT{
        mapping (address => bool) m;
    }

    function _grantPrivilege(STRUCT storage s, address a) private view {
        require(!s.m[a]); // error!! 
    }

}
