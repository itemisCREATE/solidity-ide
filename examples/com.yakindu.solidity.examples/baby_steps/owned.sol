//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract owned {

    constructor () public {
        owner = msg.sender;
    }

    modifier onlyowner() {
        if (msg.sender == owner) _;
    }

    address payable owner;
}


