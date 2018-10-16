contract AbstractB {
    function getX() payable returns(uint)  {
        return 3;
    }
}
contract A { 
    function makeCall(address addressB) {
         AbstractB(addressB).getX.gas(10).value(1000 ether);
         AbstractB(addressB).getX.gas(100).value(1000 ether)(); 
    }
} 