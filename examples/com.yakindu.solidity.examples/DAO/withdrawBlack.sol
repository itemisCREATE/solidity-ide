/*
This file is part of the DAO.

The DAO is free software: you can redistribute it and/or modify
it under the terms of the GNU lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

The DAO is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU lesser General Public License for more details.

You should have received a copy of the GNU lesser General Public License
along with the DAO.  If not, see <http://www.gnu.org/licenses/>.
*/

// TODO: all constants need to be double checked
import "github.com/slockit/DAO/DAO.sol";

contract Withdraw {
    DAO constant public mother = DAO(0xbb9bc244d798123fde783fcc1c72d3bb8c189413);
    mapping (address => bool) public blackList;
    uint constant public totalSupply = 11712722930974665882186911;
    uint constant public totalWeiSupply = 12072858342395652843028271;
    uint constant public fixChildDAOsListTime = 1468057560; // 09.07.2016 - 11:46:00 CEST

    function Withdraw(){
        // These are the child DAOs where the recursive call exploit was used,
        // their token balances are invalid.
        blackList[0xb136707642a4ea12fb4bae820f03d2562ebff487] = true;
        blackList[0x304a554a310c7e546dfe434669c62820b7d83490] = true;
        blackList[0x84ef4b2357079cd7a7c69fd7a37cd0609a679106] = true;
        blackList[0xf4c64518ea10f995918a454158c6b61407ea345c] = true;
        blackList[0x4613f3bca5c44ea06337a9e439fbc6d42e501d0a] = true;
        blackList[0xaeeb8ff27288bdabc0fa5ebb731b6f409507516c] = true;
        blackList[0xfe24cdd8648121a43a7c86d289be4dd2951ed49f] = true;
    }

    /// This function can be used to redeem child dao tokens.
    /// It can only be called 4 weeks after the blacklist was fixed.
    /// The reason is that if this more complicated mechanism has a flaw,
    /// people will hopefully already have withdrawn most of the ether
    /// through the simpler mechanism below.
    function withdrawFromChildDAO(uint _childProposalID) {
        if (now < fixChildDAOsListTime + 4 weeks) throw;
        DAO child = DAO(mother.getNewDAOAddress(_childProposalID));
        // If the child is blacklisted or too new, this does not work.
        if (address(child) == 0 || blackList[child] || child.lastTimeMinQuorumMet() > fixChildDAOsListTime)
            throw;

        withdraw(child);
    }

    /// Withdraw your share of the Ether.
    /// Prior to calling this function, you have to approve allow the withdraw
    /// contract to transfer your DAO tokens to it.
    function withdraw() {
        withdraw(mother);
    }

    function withdraw(DAO dao) internal {
        uint balance = dao.balanceOf(msg.sender);

        // The msg.sender must call approve(this, balance) beforehand so that
        // transferFrom() will work and not throw. We need transferFrom()
        // instead of transfer() due to the msg.sender in the latter ending
        // up to be the contract
        if (!dao.transferFrom(msg.sender, this, balance)
            || !msg.sender.send(balance * totalWeiSupply / totalSupply)) {

            throw;
        }
    }
}
