//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;

contract A {
    function doStuff() public { }
    function makeCall() public {
        this.doStuff();
        address(this).balance;
    }
}



