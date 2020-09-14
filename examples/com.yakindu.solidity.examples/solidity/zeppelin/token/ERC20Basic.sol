//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


/**
 * @title ERC20Basic
 * @dev Simpler version of ERC20 interface
 * @dev see https://github.com/ethereum/EIPs/issues/20
 */
abstract contract ERC20Basic {
  uint256 public totalSupply;
  function balanceOf(address who) view public virtual returns (uint256);
  function transfer(address to, uint256 value) public virtual;
  event Transfer(address indexed from, address indexed to, uint256 value);
}
