//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract Migrations {
    address public admin;
    uint public last_completed_migration;

    modifier onlyAdmin() {
        if (msg.sender == admin) _;
    }

    constructor () public {
        admin = msg.sender;
    }

    function setCompleted(uint completed) onlyAdmin public {
        last_completed_migration = completed;
    }
}


