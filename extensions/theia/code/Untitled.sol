pragma solidity ^0.5.8;

contract MyContract {
    address payable creator;
    
    constructor () public {
        creator = msg.sender;
        kill();
    }
	
    function kill() public {
        if (msg.sender == creator) {
            selfdestruct(creator); 
        }
    }
}