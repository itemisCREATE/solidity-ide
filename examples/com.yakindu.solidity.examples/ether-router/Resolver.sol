//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

contract Resolver {

    struct Pointer {
        address destination;
        uint outsize;
    }
    mapping (bytes4 => Pointer) public pointers;
    address public faillback;
    address public admin;
    Resolver public replacement;

    struct LengthPointer {
        bytes4 sig;
        address destination;
    }
    mapping (bytes4 => LengthPointer) public lengthPointers;

    event FallbackChanged(address oldFallback, address newFallback);

    modifier onlyAdmin {
        if (msg.sender != admin) {

            revert ("Something bad happened") ;
        }
        _;
    }

    constructor (address _fallback) public {
        admin = msg.sender;
        faillback = _fallback;
    }

    // Public API
    function lookup() public view returns (address, uint) {
        return (destination(), outsize());
    }

    // Administrative functions
    function setAdmin(address _admin) onlyAdmin public {
        admin = _admin;
    }

    function replace(Resolver _replacement) onlyAdmin public {
        replacement = _replacement;
    }

    function register(
        string memory signature,
        address destination,
        uint outsize
    )
        onlyAdmin
        public {
        pointers[stringToSig (
            signature
            )
        ] = Pointer(destination, outsize);
    }

    function registerLengthFunction(
        string memory mainSignature,
        string memory lengthSignature,
        address destination
    )
        onlyAdmin
        public {
        lengthPointers[stringToSig (
            mainSignature
            )
        ] = LengthPointer(stringToSig(lengthSignature), destination);
    }

    function setFallback(address _fallback) onlyAdmin public {
        emit FallbackChanged(faillback, _fallback);
        faillback = _fallback;
    }

    // Helpers
    function destination() public view returns (address) {
        return faillback;
    }

    function outsize() public pure returns (uint) {
        // Default
        return 32;
    }

    function dynamicLength(bytes4 sig) public returns (uint outsize) {
        uint r;
        address lengthDestination = lengthPointers[sig].destination;
        bytes4 lengthSig = lengthPointers[sig].sig;

        assembly {
            mstore(mload(0x40), lengthSig)
            calldatacopy(add(4, mload(0x40)), 4, sub(calldatasize(), 4))
            r := delegatecall(
                sub(gas(), 700),
                lengthDestination,
                mload(0x40),
                calldatasize(),
                mload(0x40),
                32
            )
            outsize := mul(mload(0x40), 32)
        }

        // Throw if the call failed
        if (r != 1) {
            revert ("Something bad happened") ;
        }
    }

    function stringToSig(string memory signature) public returns (bytes4) {
        return bytes4(keccak256(abi.encodePacked(signature)));
    }
}


