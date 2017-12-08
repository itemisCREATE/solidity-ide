pragma solidity ^0.4.18;


contract DestinationCall {
    address dest;

    function(){
        if (!dest.call("")) {
            throw;
        }
    }
}


