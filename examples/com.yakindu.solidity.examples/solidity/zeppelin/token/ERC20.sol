//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


import './ERC20Basic.sol';


/**
 * @title ERC20 interface
 * @dev see https://github.com/ethereum/EIPs/issues/20
 */
abstract contract ERC20 is ERC20Basic {
  function allowance(address owner, address spender) view public virtual returns (uint256);
  function transferFrom(address from, address to, uint256 value) public virtual;
  function approve(address spender, uint256 value) public virtual;
  event Approval(address indexed owner, address indexed spender, uint256 value);
}
