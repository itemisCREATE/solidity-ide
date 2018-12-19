pragma solidity ^0.5.1;


contract Test7 {
    struct Proposal{
        bytes32 name;
        uint voteCount;
    }
    Proposal[] public proposals;

    function init(){
        proposals.push(Proposal({
                voteCount: 0,
                name: "Test"
            }));
    }

    function callMe(int32 i, bool b) public{
        callMe({b : false, i : 5});
    }
}


