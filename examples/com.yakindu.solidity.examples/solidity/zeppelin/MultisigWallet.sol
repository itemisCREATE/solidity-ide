//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import "./ownership/Multisig.sol";
import "./ownership/Shareable.sol";
import "./DayLimit.sol";


abstract contract MultisigWallet is Multisig, Shareable, DayLimit {

    struct Transaction {
        address to;
        uint256 value;
        bytes data;
    }

    constructor (address[] memory _owners , uint256 _required , uint256 _daylimit) Shareable(_owners, _required) DayLimit(_daylimit) public {

    }

    function destroy(address payable _to) onlymanyowners(keccak256(msg.data)) external {
        selfdestruct(_to);
    }

  fallback() payable external {
        // just being sent some cash?
        if (msg.value > 0)
      Deposit(msg.sender, msg.value);
    }

    function execute(address _to, uint256 _value, bytes calldata _data) external override onlyOwner returns (bytes32 _r) {
        // first, take the opportunity to check that we're under the daily limit.
        if (underLimit(_value)) {
            SingleTransact(msg.sender, _value, _to, _data);
            // yes - just execute the call.
            return 0;
        }
        _r = keccak256(abi.encodePacked(msg.data, block.number));
        if (!confirm(_r) && txs[_r].to == address(0)) {
            txs[_r].to = _to;
            txs[_r].value = _value;
            txs[_r].data = _data;
            ConfirmationNeeded(_r, msg.sender, _value, _to, _data);
        }
    }

    function confirm(bytes32 _h) onlymanyowners(_h) public override returns (bool) {
        if (txs[_h].to != address(0)) {
            MultiTransact(msg.sender, _h, txs[_h].value, txs[_h].to, txs[_h].data);
            delete txs[_h];
            return true;
        }
    }

    function setDailyLimit(
        uint256 _newLimit
    )
        onlymanyowners(keccak256 (
                msg.data
                )
        )
        external {
        _setDailyLimit(_newLimit);
    }

    function resetSpentToday() onlymanyowners(keccak256(msg.data)) external {
        _resetSpentToday();
    }


    function clearPending() internal override {
        uint256 length = pendingsIndex.length;
        for (uint256 i = 0; i < length;++i) {
            delete txs[pendingsIndex[i]];
        }
        super.clearPending();
    }

    mapping (bytes32 => Transaction) txs;
}


