//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "./Resolver.sol";

contract EtherRouter {
    Resolver resolver;

    constructor (Resolver _resolver) public {
        resolver = _resolver;
    }

  fallback() payable external {
        uint r;

        // Get routing information for the called function
        (address destination, uint256 outsize) = resolver.lookup();

        // Make the call
        assembly {
            calldatacopy(mload(0x40), 0, calldatasize())
            r := delegatecall(
                sub(gas(), 700),
                destination,
                mload(0x40),
                calldatasize(),
                mload(0x40),
                outsize
            )
        }

        // Throw if the call failed
        if (r != 1) {

            revert ("Something bad happened") ;
        }

        // Pass on the return value
        assembly {
            return(mload(0x40), outsize)
        }
    }
}


