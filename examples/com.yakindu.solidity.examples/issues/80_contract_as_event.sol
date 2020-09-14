//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;

contract Contract {
    
    event E(address a);

    function f() public {
       
        Contract2 c = new Contract2();
        
        emit E(address(c)); // error: Incompatible Types    
         
        emit E(address(new Contract2())); // OK   
    } 

}

contract Contract2 {
    
    event E(address a);

    function f() public {
    } 

}
 