//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import './ERC20Basic.sol';

contract TokenTimelock {

    ERC20Basic token;

    address beneficiary;

    uint releaseTime;

    constructor (ERC20Basic _token , address _beneficiary , uint _releaseTime) public {
        require(_releaseTime > now);
        token = _token;
        beneficiary = _beneficiary;
        releaseTime = _releaseTime;
    }

    function claim() public {
        require(msg.sender == beneficiary);
        require(now >= releaseTime);

        uint amount = token.balanceOf(address(this));
        require(amount > 0);

        token.transfer(beneficiary, amount);
    }
}


