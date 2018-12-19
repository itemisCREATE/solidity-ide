pragma solidity ^0.5.1;

contract NamedParameter{
    function callMe(int32 i, bool b) public{
        callMe({b : false, i : 5});
    }
}
