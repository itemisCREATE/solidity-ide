pragma solidity ^0.4.25;
//import "../files2/my_contract2.sol";
contract MyContract {
    address creator;

    constructor() public{
        creator = msg.sender;
    }

    // TODO Add functions

    /**********
     Standard kill() function to recover funds 
     **********/
    function kill() private {
        if (msg.sender == creator) {selfdestruct(creator);}
    }
}
