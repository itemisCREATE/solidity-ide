//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract MyContract {

    constructor () public {
    }
    string  signature ="";

    function test() internal view {
        bytes memory one = abi.encode("test");
        bytes memory two = abi.encodePacked("test");
        bytes4 selector;
        bytes memory three = abi.encodeWithSelector(selector);
        bytes memory three2 = abi.encodeWithSelector(selector, "", 5);
        bytes memory four = abi.encodeWithSignature(signature);
        bytes memory four2 = abi.encodeWithSignature(signature, "", 5);
    }
}
