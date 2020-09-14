//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract safeMath {
    function safeAdd(uint256 a, uint256 b) public pure returns(uint256) {
        /*
            Biztonsagos hozzadas. Tulcsordulas elleni vedelem.
            A vegeredmeny nem lehet kevesebb mint az @a, ha igen megall a kod.
            
            @a          Amihez hozzaadni kell
            @b          Amennyit hozzaadni kell.
            @uint256    Vegeredmeny.
        */
        if ( b > 0 ) {
            assert( a + b > a );
        }
        return a + b;
    }
        
    function safeSub(uint256 a, uint256 b) public pure returns(uint256) {
        /*
            Biztonsagos kivonas. Tulcsordulas elleni vedelem.
            A vegeredmeny nem lehet tobb mint az @a, ha igen megall a kod.
            
            @a          Amibol kivonni kell.
            @b          Amennyit kivonni kell.
            @uint256    Vegeredmeny.
        */
        if ( b > 0 ) {
            assert( a - b < a );
        }
        return a - b;
    }
}