//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "../ownership/Ownable.sol";

contract Destructible is Ownable {

    constructor () payable public {

    }

    function destroy() onlyOwner public {
        selfdestruct(owner);
    }

    function destroyAndSend(address payable _recipient) onlyOwner public {
        selfdestruct(_recipient);
    }
}


