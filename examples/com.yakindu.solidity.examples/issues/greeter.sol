pragma solidity ^0.5.1;

contract mortal{ /* Define variable owner of the type address */
    address owner;
    constructor () internal{
        owner=msg.sender;
    } /* Function to recover the funds on the contract */
    function kill() public{        if (msg.sender == owner) selfdestruct(owner);
    }
}
contract greeter is mortal{ /* Define variable greeting of the type string */
    string greeting;
    constructor (string _greeting) public{ greeting = _greeting;
    } /* Main function */
    function greet() view external returns (string){
        return greeting;
        
    }
}
