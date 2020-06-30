// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.6.10 <0.7.0;

contract Test {
    // This function is called for all messages sent to
    // this contract (there is no other function).
    // Sending Ether to this contract will cause an exception,
    // because the fallback function does not have the `payable`
    // modifier.
    fallback() external { x = 1; }
    uint x;
}