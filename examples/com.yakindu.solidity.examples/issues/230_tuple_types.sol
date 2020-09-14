//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10 ;

contract C {
    uint[] data;

    function f() public pure returns (uint, bool, uint) {
        return (7, true, 2);
    }

    function g() public pure {
        // Variables declared with type and assigned from the returned tuple,
        // not all elements have to be specified (but the number must match).
        (uint x, , uint y) = f(); 
        // Common trick to swap values -- does not work for non-value storage types.
        (x, y) = (y, x);
    }
}