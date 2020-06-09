// SPDX-License-Identifier: GPL-3.0
pragma solidity >=^0.6.0 <^0.7.0;

abstract contract Feline {
    function utterance() public virtual returns (bytes32);
}