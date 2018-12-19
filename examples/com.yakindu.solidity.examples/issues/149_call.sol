pragma solidity ^0.5.1;


contract MyContract {
    constructor () public{
    }

    function test() internal {
        address a;
        bool c1 = a.call("");
        bytes b;
        bool c2 = a.call(b);
        bool b3 = a.call(b, "", 5);
        bool b4 = a.call("", b, 5);
    }
}