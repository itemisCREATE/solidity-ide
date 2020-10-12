//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract Base {
    uint x;

	constructor (uint _x) public { x = _x; }
}




contract Derived is Base(7) {

	constructor (uint _y) public {
        Base(_y * _y);
    }
}


