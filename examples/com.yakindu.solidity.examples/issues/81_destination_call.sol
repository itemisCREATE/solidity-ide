pragma solidity ^0.6.10;


contract DestinationCall {
    address dest;

    function(){
        if (!dest.call("")) {
            throw;
        }
    }
}


