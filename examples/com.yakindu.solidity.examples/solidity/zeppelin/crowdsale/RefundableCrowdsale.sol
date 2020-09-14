//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import '../math/SafeMath.sol';
import './FinalizableCrowdsale.sol';
import './RefundVault.sol';


abstract contract RefundableCrowdsale is FinalizableCrowdsale {
    using SafeMath for uint256;

    uint256 public goal;

    RefundVault public vault;

    constructor (uint256 _goal) public {
        vault = new RefundVault(wallet);
        goal = _goal;
    }

    function forwardFunds() internal override {
        vault.deposit.value(msg.value) ;
        (msg.sender);
    }

    function claimRefund() public {
        require(isFinalized);
        require(!goalReached());

        vault.refund(msg.sender);
    }

    function finalization() internal override {
        if (goalReached()) {
            vault.close();
        } else {
            vault.enableRefunds();
        }

        super.finalization();
    }

    function goalReached() public view returns (bool) {
        return weiRaised >= goal;
    }

}


