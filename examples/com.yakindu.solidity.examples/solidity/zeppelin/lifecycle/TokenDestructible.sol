//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import "../ownership/Ownable.sol";
import "../token/ERC20Basic.sol";

contract TokenDestructible is Ownable {

    constructor () payable public {

    }

    function destroy(address[] memory tokens) onlyOwner public {

        // Transfer tokens to owner
        for (uint256 i = 0; i < tokens.length;i++) {
            ERC20Basic token = ERC20Basic(tokens[i]);
            uint256 balance = token.balanceOf(address(this));
            token.transfer(owner, balance);
        }

        // Transfer Eth to owner and terminate contract
        selfdestruct(owner);
    }
}


