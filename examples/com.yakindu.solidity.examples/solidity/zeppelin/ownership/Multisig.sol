//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


/**
 * @title Multisig
 * @dev Interface contract for multisig proxy contracts; see below for docs.
 */
abstract contract Multisig {
  // EVENTS

  // logged events:
  // Funds has arrived into the wallet (record how much).
  event Deposit(address _from, uint256 value);
  // Single transaction going out of the wallet (record who signed for it, how much, and to whom it's going).
  event SingleTransact(address owner, uint256 value, address to, bytes data);
  // Multi-sig transaction going out of the wallet (record who signed for it last, the operation hash, how much, and to whom it's going).
  event MultiTransact(address owner, bytes32 operation, uint256 value, address to, bytes data);
  // Confirmation still needed for a transaction.
  event ConfirmationNeeded(bytes32 operation, address initiator, uint256 value, address to, bytes data);


  // FUNCTIONS

  // TODO: document
  function changeOwner(address _from, address _to) external virtual;
  function execute(address _to, uint256 _value, bytes memory _data) external virtual returns (bytes32);
  function confirm(bytes32 _h) public virtual returns (bool);
}
