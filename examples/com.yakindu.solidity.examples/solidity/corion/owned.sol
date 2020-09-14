//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract ownedDB {
    address private owner;
    
    function replaceOwner(address newOwner) external returns(bool) {
        /*
            Owner replace.
            
            @newOwner   Address of new owner.
        */
        require( isOwner() );
        owner = newOwner;
        return true;
    }
    
    function isOwner() internal view returns (bool) {
        /*
            Check of owner address.
            
            @bool   Owner has called the contract or not 
        */
        return owner == msg.sender;
    }
}
