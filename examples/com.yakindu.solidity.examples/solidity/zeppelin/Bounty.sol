// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.6.10;


import './payment/PullPayment.sol';
import './lifecycle/Destructible.sol';


/**
 * @title Bounty 
 * @dev This bounty will pay out to a researcher if they break invariant logic of the contract.
 */
abstract contract Bounty is PullPayment, Destructible {
    bool public claimed;
    mapping(address => address) public researchers;

    event TargetCreated(address createdAddress);

  /**
   * @dev Fallback function allowing the contract to recieve funds, if they haven't already been claimed.
   */
  fallback() payable external {
        if (claimed) {
            revert("Something bad happened!");
        }
    }

    /**
     * @dev Create and deploy the target contract (extension of Target contract), and sets the 
     * msg.sender as a researcher
     * @return A target contract
     */
    function createTarget() public returns (Target) {
        Target target = Target(deployContract());
        researchers[address(target)] = msg.sender;
        emit TargetCreated(address(target));
        return target;
    }

    /**
     * @dev Internal function to deploy the target contract.
     * @return A target contract address
     */
    function deployContract() internal virtual returns(address);

    /**
     * @dev Sends the contract funds to the researcher that proved the contract is broken.
     * @param target contract
     */
    function claim(Target target) public {
        address researcher = researchers[address(target)];
        if (researcher == address(0)) {
            revert ("Something bad happened") ;
        }
        // Check Target contract invariants
        if (target.checkInvariant()) {
            revert ("Something bad happened") ;
        }
        asyncSend(researcher, address(this).balance);
        claimed = true;
    }

}


/**
 * @title Target
 * @dev Your main contract should inherit from this class and implement the checkInvariant method.
 */
abstract contract Target {

    /**
     * @dev Checks all values a contract assumes to be true all the time. If this function returns 
     * false, the contract is broken in some way and is in an inconsistent state. 
     * In order to win the bounty, security researchers will try to cause this broken state. 
     * @return True if all invariant values are correct, false otherwise. 
     */
    function checkInvariant() public virtual returns (bool);
}


