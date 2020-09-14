//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;


contract Shareable {

    struct PendingState {
        uint256 yetNeeded;
        uint256 ownersDone;
        uint256 index;
    }

    uint256 public required;

    address[256] owners;
    mapping(address => uint256) ownerIndex;
    mapping(bytes32 => PendingState) pendings;
    bytes32[] pendingsIndex;

    event Confirmation(address owner, bytes32 operation);
    event Revoke(address owner, bytes32 operation);

    modifier onlyOwner {
        if (!isOwner(msg.sender)) {
            revert("Something bad happened!");
        }
        _;
    }

    modifier onlymanyowners(bytes32 _operation) {
        if (confirmAndCheck(_operation)) {
            _;
        }
    }

	constructor (address[] memory _owners , uint256 _required) public {
        owners[1] = msg.sender;
        ownerIndex[msg.sender] = 1;
        for (uint256 i = 0; i < _owners.length;++i) {
            owners[2 + i] = _owners[i];
            ownerIndex[_owners[i]] = 2 + i;
        }
        required = _required;
        if (required > owners.length) {
            revert("Something bad happened!");
        }
    }

    function revoke(bytes32 _operation) external {
        uint256 index = ownerIndex[msg.sender];
        // make sure they're an owner
        if (index == 0) {
            return;
        }
        uint256 ownerIndexBit = 2 ** index;
        PendingState memory pending = pendings[_operation];
        if (pending.ownersDone & ownerIndexBit > 0) {
            pending.yetNeeded++;
            pending.ownersDone -= ownerIndexBit;
            emit Revoke(msg.sender, _operation);
        }
    }

    function getOwner(uint256 ownerIndex) external view returns (address) {
        return address(owners[ownerIndex + 1]);
    }

    function isOwner(address _addr) view public returns (bool) {
        return ownerIndex[_addr] > 0;
    }

    function hasConfirmed(bytes32 _operation, address _owner) view public returns (bool) {
        PendingState storage pending = pendings[_operation];
        uint256 index = ownerIndex[_owner];

        if (index == 0) {
            return false;
        }

        uint256 ownerIndexBit = 2 ** index;
        return!(pending.ownersDone & ownerIndexBit == 0);
    }

    function confirmAndCheck(bytes32 _operation) internal returns (bool) {
        uint256 index = ownerIndex[msg.sender];
        if (index == 0) {
            revert("Something bad happened!");
        }

        PendingState storage pending = pendings[_operation];
        if (pending.yetNeeded == 0) {
            pending.yetNeeded = required;
            pending.ownersDone = 0;
            pendingsIndex[pending.index] = _operation;
        }
        uint256 ownerIndexBit = 2 ** index;
        if (pending.ownersDone & ownerIndexBit == 0) {
            emit Confirmation(msg.sender, _operation);
            if (pending.yetNeeded <= 1) {
                delete pendingsIndex[pendings[_operation].index];
                delete pendings[_operation];
                return true;
            } else {
                pending.yetNeeded--;
                pending.ownersDone |= ownerIndexBit;
            }
        }
        return false;
    }

    function clearPending() internal {
        uint256 length = pendingsIndex.length;
        for (uint256 i = 0; i < length;++i) {
            if (pendingsIndex[i] != 0) {
                delete pendings[pendingsIndex[i]];
            }
        }
        delete pendingsIndex;
    }

}





