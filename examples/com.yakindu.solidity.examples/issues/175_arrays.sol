pragma solidity 0.6.10;

contract MySubContract {

    MySubContract[] public subcontracts;
	MySubContract[][] public subcontracts2;
    function testIt() public view{
        subcontracts[1].testIt();
        subcontracts2[1][1].testIt();
    }

}

contract ArrayTest {

    MySubContract subContract;

    function fun() public view{
        subContract.subcontracts(1). testIt(); 
        subContract.subcontracts2(1,2).testIt();
    }
}
