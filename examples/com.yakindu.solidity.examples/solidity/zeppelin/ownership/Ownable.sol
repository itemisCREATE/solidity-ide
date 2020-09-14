//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract Ownable {
    address payable public owner;

    constructor () public {
        owner = msg.sender;
    }


    modifier onlyOwner() {
        if (msg.sender != owner) {
            revert("Something bad happened!");
        }
        _;
    }

    function transferOwnership(address payable newOwner) onlyOwner public {
        if (newOwner != address(0)) {
            owner = newOwner;
        }
    }

}


