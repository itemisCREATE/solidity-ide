//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "./Factory.sol";
import "./MultiSigWalletWithDailyLimit.sol";


contract MultiSigWalletWithDailyLimitFactory is Factory {

    function create(address[] _owners, uint _required, uint _dailyLimit)
        public
        returns (address wallet)
    {
        wallet = new MultiSigWalletWithDailyLimit(_owners, _required, _dailyLimit);
        register(wallet);
    }
}
