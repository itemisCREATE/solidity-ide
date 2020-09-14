//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import './BasicToken.sol';
import './ERC20.sol';


contract StandardToken is ERC20, BasicToken {

  mapping (address => mapping (address => uint256)) allowed;


  function transferFrom(address _from, address _to, uint256 _value) public override{
    uint256 _allowance = allowed[_from][msg.sender];

    balances[_to] = balances[_to].add(_value);
    balances[_from] = balances[_from].sub(_value);
    allowed[_from][msg.sender] = _allowance.sub(_value);
    Transfer(_from, _to, _value);
  }

  function approve(address _spender, uint256 _value) public override {

    if ((_value != 0) && (allowed[msg.sender][_spender] != 0)) revert("Something bad happened!");

    allowed[msg.sender][_spender] = _value;
    Approval(msg.sender, _spender, _value);
  }

  function allowance(address _owner, address _spender) view public override returns (uint256 remaining) {
    return allowed[_owner][_spender];
  }

}
