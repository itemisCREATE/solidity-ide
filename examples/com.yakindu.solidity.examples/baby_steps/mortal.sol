//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "./owned.sol";

contract mortal is owned {

    function kill() public {
        if (msg.sender == owner) selfdestruct(owner);
    }
}


