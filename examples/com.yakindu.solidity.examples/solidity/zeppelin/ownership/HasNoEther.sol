//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "./Ownable.sol";

contract HasNoEther is Ownable {

    constructor () payable public {
        if (msg.value > 0) {
            revert ("Something bad happened") ;
        }
    }

  	fallback() external {
    }

    function reclaimEther() external onlyOwner {
        if (!owner.send(address(this).balance)) {
            revert ("Something bad happened") ;
        }
    }
}


