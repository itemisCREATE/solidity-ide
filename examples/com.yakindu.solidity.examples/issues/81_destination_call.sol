pragma solidity ^0.5.1;


contract DestinationCall {
    address dest;

    function(){
        if (!dest.call("")) {
            throw;
        }
    }
}


