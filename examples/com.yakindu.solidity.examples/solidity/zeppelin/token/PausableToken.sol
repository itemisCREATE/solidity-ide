//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import './StandardToken.sol';
import '../lifecycle/Pausable.sol';

contract PausableToken is StandardToken, Pausable {

  function transfer(address _to, uint _value) whenNotPaused public override {
    super.transfer(_to, _value);
  }

  function transferFrom(address _from, address _to, uint _value) whenNotPaused public override {
    super.transferFrom(_from, _to, _value);
  }
}
