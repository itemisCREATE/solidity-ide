//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Tokens/StandardToken.sol";

contract EtherToken is StandardToken {
    using Math for *;

    event Deposit(address indexed sender, uint value);
    event Withdrawal(address indexed receiver, uint value);

    string public constant name = "Ether Token";
    string public constant symbol = "ETH";
    uint8 public constant decimals = 18;

    function deposit()
        public
        payable
    {
        balances[msg.sender] = balances[msg.sender].add(msg.value);
        totalTokens = totalTokens.add(msg.value);
        Deposit(msg.sender, msg.value);
    }

    function withdraw(uint value)
        public
    {
        balances[msg.sender] = balances[msg.sender].sub(value);
        totalTokens = totalTokens.sub(value);
        msg.sender.transfer(value);
        Withdrawal(msg.sender, value);
    }
}
