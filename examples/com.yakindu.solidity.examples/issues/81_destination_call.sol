//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract DestinationCall {
    address dest;

    fallback() external {
        (bool success,) = dest.call("");
        if (!success) {
            revert ("Something bad happened") ;
        }
    }
}


