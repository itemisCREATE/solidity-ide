//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import "./StandardToken.sol";

contract SimpleToken is StandardToken {

    string public name = "SimpleToken";
    string public symbol = "SIM";
    uint256 public decimals = 18;
    uint256 public INITIAL_SUPPLY = 10000;

    constructor () public {
        totalSupply = INITIAL_SUPPLY;
        balances[msg.sender] = INITIAL_SUPPLY;
    }

}


