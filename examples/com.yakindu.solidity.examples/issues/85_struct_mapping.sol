pragma solidity ^0.4.18;


contract StructMapping {
    struct STRUCT{
        mapping (address => bool) m;
    }

    function _grantPrivilege(STRUCT storage s, address a){
        require(!s.m[a]); // error!!
    }
}


 