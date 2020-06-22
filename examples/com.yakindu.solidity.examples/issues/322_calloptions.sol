// SPDX-License-Identifier: GPL-3.0
pragma solidity >=^0.6.0 <^0.7.0;
// This will report a warning

contract Example {
    function f() public payable returns (bytes4) {
        assert(this.f.address == address(this));
        return this.f.selector;
    }

    function g() public {
        this.f{gas: 10, value: 800}();
    }
}