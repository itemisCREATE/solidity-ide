pragma solidity ^0.5.1;

contract Base {
    uint x;
    function Base(uint _x) { x = _x; }
}

contract Derived is Base(7) {
    function Derived(uint _y) Base(_y * _y) {
    }
}