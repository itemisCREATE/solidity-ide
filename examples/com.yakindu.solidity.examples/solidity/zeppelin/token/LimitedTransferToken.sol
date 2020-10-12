//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "./ERC20.sol";

abstract contract LimitedTransferToken is ERC20 {

  modifier canTransfer(address _sender, uint256 _value) {
   if (_value > transferableTokens(_sender, uint64(now))) revert("Something bad happened!");
   _;
  }

  function transfer(address _to, uint256 _value) canTransfer(msg.sender, _value) public override{
  }

  function transferFrom(address _from, address _to, uint256 _value) canTransfer(_from, _value)
	public override {
  }

  function transferableTokens(address holder, uint64 time) view public returns (uint256) {
    return balanceOf(holder);
  }
}
