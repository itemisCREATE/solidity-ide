//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Tokens/Token.sol";
import "../Utils/Math.sol";


contract StandardToken is Token {
    using Math for *;

    /*
     *  Storage
     */
    mapping (address => uint) balances;
    mapping (address => mapping (address => uint)) allowances;
    uint totalTokens;

    function transfer(address to, uint value)
        public override
        returns (bool)
    {
        if (   !balances[msg.sender].safeToSub(value)
            || !balances[to].safeToAdd(value))
            return false;
        balances[msg.sender] -= value;
        balances[to] += value;
        emit Transfer(msg.sender, to, value);
        return true;
    }

    function transferFrom(address from, address to, uint value)
        public override
        returns (bool)
    {
        if (   !balances[from].safeToSub(value)
            || !allowances[from][msg.sender].safeToSub(value)
            || !balances[to].safeToAdd(value))
            return false;
        balances[from] -= value;
        allowances[from][msg.sender] -= value;
        balances[to] += value;
        emit Transfer(from, to, value);
        return true;
    }

    function approve(address spender, uint value)
        public override
        returns (bool)
    {
        allowances[msg.sender][spender] = value;
        emit Approval(msg.sender, spender, value);
        return true;
    }

    function allowance(address owner, address spender)
        public view override
        returns (uint)
    {
        return allowances[owner][spender];
    }

    function balanceOf(address owner)
        public view override
        returns (uint)
    {
        return balances[owner];
    }

    function totalSupply()
        public view override
        returns (uint)
    {
        return totalTokens;
    }
}
