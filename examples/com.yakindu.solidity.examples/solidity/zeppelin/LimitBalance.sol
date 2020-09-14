//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract LimitBalance {

    uint256 public limit;

    constructor (uint256 _limit) public {
        limit = _limit;
    }

    modifier limitedPayable() {
        if (address(this).balance > limit) {
            revert ("Something bad happened") ;
        }
        _;

    }

}


