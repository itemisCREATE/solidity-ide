pragma solidity ^0.4.23;


contract MyContract {
    constructor () public{
    }

    function test() internal{
        bytes memory one = abi.encode("test");
        bytes memory two = abi.encodePacked("test");
        bytes4 selector;
        bytes memory three = abi.encodeWithSelector(selector);
        bytes memory three2 = abi.encodeWithSelector(selector, "", 5);
        string storage signature;
        bytes memory four = abi.encodeWithSignature(signature);
        bytes memory four2 = abi.encodeWithSignature(signature, "", 5);
    }
}