//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";

contract SignedMessageOracle is Oracle {

    /*
     *  Events
     */
    event SignerReplacement(address indexed newSigner);
    event OutcomeAssignment(int outcome);

    /*
     *  Storage
     */
    address public signer;
    bytes32 public descriptionHash;
    uint nonce;
    bool public isSet;
    int public outcome;

    /*
     *  Modifiers
     */
    modifier isSigner () {
        // Only signer is allowed to proceed
        require(msg.sender == signer);
        _;
    }

	constructor (bytes32 _descriptionHash , uint8 v , bytes32 r , bytes32 s) public {
        signer = ecrecover(_descriptionHash, v, r, s);
        descriptionHash = _descriptionHash;
    }

    function replaceSigner(address newSigner, uint _nonce, uint8 v, bytes32 r, bytes32 s)
        public
        isSigner
    {
        // Result is not set yet and nonce and signer are valid
        require(   !isSet
                && _nonce > nonce
                && signer == ecrecover(keccak256(abi.encodePacked(descriptionHash, newSigner, _nonce)), v, r, s));
        nonce = _nonce;
        signer = newSigner;
        emit SignerReplacement(newSigner);
    }

    function setOutcome(int _outcome, uint8 v, bytes32 r, bytes32 s)
        public
    {
        // Result is not set yet and signer is valid
        require(   !isSet
                && signer == ecrecover(keccak256(abi.encodePacked(descriptionHash, _outcome)), v, r, s));
        isSet = true;
        outcome = _outcome;
        OutcomeAssignment(_outcome);
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



