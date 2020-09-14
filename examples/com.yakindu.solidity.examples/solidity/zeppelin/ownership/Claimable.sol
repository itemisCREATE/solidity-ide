//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import './Ownable.sol';

contract Claimable is Ownable {
  address payable public pendingOwner;

  modifier onlyPendingOwner() {
    if (msg.sender != pendingOwner) {
      revert("Something bad happened!");
    }
    _;
  }

  function transferOwnership(address payable newOwner) onlyOwner public override {
    pendingOwner = newOwner;
  }

  function claimOwnership() onlyPendingOwner public {
    owner = pendingOwner;
    pendingOwner = address(0x0);
  }
}
