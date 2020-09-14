//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import '../math/SafeMath.sol';
import '../ownership/Ownable.sol';

contract RefundVault is Ownable {
    using SafeMath for uint256;

    enum State {
        Active,
        Refunding,
        Closed
    }

    mapping (address => uint256) public deposited;
    address payable public wallet;
    State public state;

    event Closed();
    event RefundsEnabled();
    event Refunded(address indexed beneficiary, uint256 weiAmount);

    constructor (address payable _wallet) public {
        require(_wallet != address(0x0));
        wallet = _wallet;
        state = State.Active;
    }

    function deposit(address investor) onlyOwner payable public {
        require(state == State.Active);
        deposited[investor] = deposited[investor].add(msg.value);
    }

    function close() onlyOwner public {
        require(state == State.Active);
        state = State.Closed;
        emit Closed();
        wallet.transfer(address(this).balance);
    }

    function enableRefunds() onlyOwner public {
        require(state == State.Active);
        state = State.Refunding;
        emit RefundsEnabled();
    }

    function refund(address payable investor) public {
        require(state == State.Refunding);
        uint256 depositedValue = deposited[investor];
        deposited[investor] = 0;
        investor.transfer(depositedValue);
        emit Refunded(investor, depositedValue);
    }
}


