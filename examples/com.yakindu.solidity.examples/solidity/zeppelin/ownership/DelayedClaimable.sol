//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import './Claimable.sol';

contract DelayedClaimable is Claimable {

    uint256 public end;
    uint256 public start;

    function setLimits(uint256 _start, uint256 _end) onlyOwner public {
        if (_start > _end)
        revert("Something bad happened!");
        end = _end;
        start = _start;
    }

    function claimOwnership() onlyPendingOwner public override {
        if ((block.number > end) || (block.number < start))
        revert("Something bad happened!");
        owner = pendingOwner;
        pendingOwner = address(0x0);
        end = 0;
    }

}


