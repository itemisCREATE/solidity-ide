//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Tokens/StandardToken.sol";


contract OutcomeToken is StandardToken {
    using Math for *;

    event Issuance(address indexed owner, uint amount);
    event Revocation(address indexed owner, uint amount);

    address public eventContract;

    modifier isEventContract () {
        require(msg.sender == eventContract);
        _;
    }

	constructor () public {
        eventContract = msg.sender;
    }

    function issue(address _for, uint outcomeTokenCount)
        public
        isEventContract
    {
        balances[_for] = balances[_for].add(outcomeTokenCount);
        totalTokens = totalTokens.add(outcomeTokenCount);
        Issuance(_for, outcomeTokenCount);
    }

    function revoke(address _for, uint outcomeTokenCount)
        public
        isEventContract
    {
        balances[_for] = balances[_for].sub(outcomeTokenCount);
        totalTokens = totalTokens.sub(outcomeTokenCount);
        Revocation(_for, outcomeTokenCount);
    }
}



