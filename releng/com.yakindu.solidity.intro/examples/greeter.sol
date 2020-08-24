// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.9 ;

contract mortal {
    /* Define variable owner of the type address */
    address payable owner;

	constructor () public { owner = msg.sender; }

    /* Function to recover the funds on the contract */
    function kill() public { if (msg.sender == owner) selfdestruct(owner); }
}




contract greeter is mortal {
    /* Define variable greeting of the type string */
    string greeting;

	constructor (string memory _greeting) public {
        greeting = _greeting;
    }

    /* Main function */
    function greet() view public returns (string memory) {
        return greeting;
    }
}

