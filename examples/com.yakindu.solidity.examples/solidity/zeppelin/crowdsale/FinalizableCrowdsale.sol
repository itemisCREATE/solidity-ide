//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import '../math/SafeMath.sol';
import '../ownership/Ownable.sol';
import './Crowdsale.sol';

abstract contract FinalizableCrowdsale is Crowdsale, Ownable {
  using SafeMath for uint256;

  bool public isFinalized = false;

  event Finalized();

  function finalize() onlyOwner public {
    require(!isFinalized);
    require(hasEnded());

    finalization();
    Finalized();
    
    isFinalized = true;
  }

  function finalization() internal {
    token.finishMinting();
  }



}
