//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";


contract CentralizedOracle is Oracle {

    /*
     *  Events
     */
    event OwnerReplacement(address indexed newOwner);
    event OutcomeAssignment(int outcome);

    /*
     *  Storage
     */
    address public owner;
    bytes public ipfsHash;
    bool public isSet;
    int public outcome;

    /*
     *  Modifiers
     */
    modifier isOwner () {
        // Only owner is allowed to proceed
        require(msg.sender == owner);
        _;
    }

	constructor (address _owner , bytes memory _ipfsHash) public {
        require(_ipfsHash.length == 46);
        owner = _owner;
        ipfsHash = _ipfsHash;
    }

    function replaceOwner(address newOwner)
        public
        isOwner
    {
        require(!isSet);
        owner = newOwner;
        emit OwnerReplacement(newOwner);
    }

    function setOutcome(int _outcome)
        public
        isOwner
    {
        require(!isSet);
        isSet = true;
        outcome = _outcome;
        emit OutcomeAssignment(_outcome);
    }

    function isOutcomeSet()
        public override
        returns (bool)
    {
        return isSet;
    }

    function getOutcome()
        public override
        returns (int)
    {
        return outcome;
    }
}



