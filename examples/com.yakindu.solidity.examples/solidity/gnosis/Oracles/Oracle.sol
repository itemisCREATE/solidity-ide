//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

abstract contract Oracle {

    function isOutcomeSet() public virtual returns (bool);
    function getOutcome() public virtual returns (int);
}
