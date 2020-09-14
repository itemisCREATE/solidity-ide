//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import './ERC20Basic.sol';
import '../math/SafeMath.sol';


contract BasicToken is ERC20Basic {
  using SafeMath for uint256;

  mapping(address => uint256) balances;

  function transfer(address _to, uint256 _value) public override {
    balances[msg.sender] = balances[msg.sender].sub(_value);
    balances[_to] = balances[_to].add(_value);
    emit Transfer(msg.sender, _to, _value);
  }

  function balanceOf(address _owner) view public override returns (uint256 balance) {
    return balances[_owner];
  }

}
