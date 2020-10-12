//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;

import "../math/Math.sol";
import "./StandardToken.sol";
import "./LimitedTransferToken.sol";

contract VestedToken is StandardToken, LimitedTransferToken {

    uint256 MAX_GRANTS_PER_ADDRESS = 20;

    struct TokenGrant {
        address granter; // 20 bytes
        uint256 value; // 32 bytes
        uint64 cliff;
        uint64 vesting;
        uint64 start; // 3 * 8 = 24 bytes
        bool revokable;
        bool burnsOnRevoke; // 2 * 1 = 2 bits? or 2 bytes?
    } // total 78 bytes = 3 sstore per operation (32 per sstore)
    mapping (address => TokenGrant[]) public grants;

    event NewTokenGrant(address indexed from, address indexed to, uint256 value, uint256 grantId);

    function grantVestedTokens(
        address _to,
        uint256 _value,
        uint64 _start,
        uint64 _cliff,
        uint64 _vesting,
        bool _revokable,
        bool _burnsOnRevoke
    )
        public {

        if (_cliff < _start || _vesting < _cliff) {
            revert ("Something bad happened") ;
        }

        if (tokenGrantsCount(_to) > MAX_GRANTS_PER_ADDRESS) revert ("Something bad happened"); // To prevent a user being spammed and have his balance locked (out of gas attack when calculating vesting).
        uint256 count = grants[_to].push(TokenGrant(_revokable ? msg.sender : 0, // avoid storing an extra 20 bytes when it is non-revokable
                _value, _cliff, _vesting, _start, _revokable, _burnsOnRevoke));

        transfer(_to, _value);

        NewTokenGrant(msg.sender, _to, _value, count - 1);
    }

    function revokeTokenGrant(address _holder, uint256 _grantId) public {
        TokenGrant memory grant = grants[_holder][_grantId];

        if (!grant.revokable) { // Check if grant was revokable
            revert ("Something bad happened");
        }

        if (grant.granter != msg.sender) { // Only granter can revoke it
            revert ("Something bad happened");
        }

        address receiver = grant.burnsOnRevoke ? 0xdead : msg.sender;

        uint256 nonVested = nonVestedTokens(grant, uint64(now));

        delete grants[_holder][_grantId];
        grants[_holder][_grantId] = grants[_holder][grants[_holder].length.sub(1)];

        balances[receiver] = balances[receiver].add(nonVested);
        balances[_holder] = balances[_holder].sub(nonVested);

        Transfer(_holder, receiver, nonVested);
    }


    function transferableTokens(address holder, uint64 time) view public returns (uint256) {
        uint256 grantIndex = tokenGrantsCount(holder);

        if (grantIndex == 0) return balanceOf(holder); // shortcut for holder without grants
        uint256 nonVested = 0;
        for (uint256 i = 0; i < grantIndex;i++) {
            nonVested = SafeMath.add(nonVested, nonVestedTokens(grants[holder][i], time));
        }

        uint256 vestedTransferable = SafeMath.sub(balanceOf(holder), nonVested);

        return Math.min256(vestedTransferable, super.transferableTokens(holder, time));
    }

    function tokenGrantsCount(address _holder) view public returns (uint256 index) {
        return grants[_holder].length;
    }

    function calculateVestedTokens(
        uint256 tokens,
        uint256 time,
        uint256 start,
        uint256 cliff,
        uint256 vesting
    )
        view public returns (
            uint256
        )
    {
        if (time < cliff) return 0;
        if (time >= vesting) return tokens;

        uint256 vestedTokens = SafeMath.div(SafeMath.mul(tokens, SafeMath.sub(time, start)), SafeMath.sub(vesting, start));

        return vestedTokens;
    }

    function tokenGrant(
        address _holder,
        uint256 _grantId
    )
        view public returns (
            address granter,
            uint256 value,
            uint256 vested,
            uint64 start,
            uint64 cliff,
            uint64 vesting,
            bool revokable,
            bool burnsOnRevoke
        )
    {
        TokenGrant memory grant = grants[_holder][_grantId];

        granter = grant.granter;
        value = grant.value;
        start = grant.start;
        cliff = grant.cliff;
        vesting = grant.vesting;
        revokable = grant.revokable;
        burnsOnRevoke = grant.burnsOnRevoke;

        vested = vestedTokens(grant, uint64(now));
    }

    function vestedTokens(TokenGrant memory grant, uint64 time) private view returns (uint256) {
        return calculateVestedTokens(grant.value, uint256(time), uint256(grant.start), uint256(grant.cliff), uint256(grant.vesting));
    }

    function nonVestedTokens(TokenGrant memory grant, uint64 time) private view returns (uint256) {
        return grant.value.sub(vestedTokens(grant, time));
    }

    function lastTokenIsTransferableDate(address holder) view public returns (uint64 date) {
        date = uint64(now);
        uint256 grantIndex = grants[holder].length;
        for (uint256 i = 0; i < grantIndex;i++) {
            date = Math.max64(grants[holder][i].vesting, date);
        }
    }
}


