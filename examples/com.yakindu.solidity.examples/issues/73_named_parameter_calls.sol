pragma solidity ^0.4.18;


contract Test7 {
    struct Proposal{
        bytes32 name;
        uint voteCount;
    }
    Proposal[] public proposals;

    function init(){
        proposals.push(Proposal({
                name: proposalNames[i],
                voteCount: 0
            }));
    }

    function callMe(int32 i, bool b) public{
        callMe({b : false, i : 5});
    }
}


