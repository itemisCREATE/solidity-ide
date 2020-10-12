//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract ERC20Interface {
    event Transfer(address indexed from, address indexed to, uint tokens);
}


contract YakinduCoin is ERC20Interface {
    address owner;
    uint _totalSupply;
    constructor() public{
        emit Transfer(address(0), owner, _totalSupply);
    }
}