//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import '../math/SafeMath.sol';
import './Crowdsale.sol';

abstract contract CappedCrowdsale is Crowdsale {
    using SafeMath for uint256;

    uint256 public cap;

    constructor (uint256 _cap) public {
        cap = _cap;
    }

    function validPurchase() internal view override returns (bool) {
        bool withinCap = weiRaised.add(msg.value) <= cap;
        return super.validPurchase() && withinCap;
    }

    function hasEnded() public view override returns (bool) {
        bool capReached = weiRaised >= cap;
        return super.hasEnded() || capReached;
    }

}


