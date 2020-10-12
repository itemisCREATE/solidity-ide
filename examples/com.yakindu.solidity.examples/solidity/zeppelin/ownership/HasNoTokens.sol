//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "./Ownable.sol";
import "../token/ERC20Basic.sol";

contract HasNoTokens is Ownable {

    function tokenFallback() external pure {
        revert ("Something bad happened") ;
    }

    function reclaimToken(address tokenAddr) external onlyOwner {
        ERC20Basic tokenInst = ERC20Basic(tokenAddr);
        uint256 balance = tokenInst.balanceOf(address(this));
        tokenInst.transfer(owner, balance);
    }
}


