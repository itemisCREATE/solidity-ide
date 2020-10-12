//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import './Ownable.sol';

contract Contactable is Ownable{

    string public contactInformation;

    function setContactInformation(string memory info) onlyOwner public {
         contactInformation = info;
     }
}
