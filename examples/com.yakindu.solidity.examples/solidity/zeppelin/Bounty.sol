pragma solidity ^0.6.9;

import '../payment/PullPayment.sol';
import './lifecycle/Destructible.sol';


/**
 * @title Bounty
 * @dev This bounty will pay out to a researcher if they break invariant logic of the contract.
 */
contract Bounty is PullPayment, Destructible {
  bool public claimed;
  mapping(address => address) public researchers;

  event TargetCreated(address createdAddress);

  /**
   * @dev Internal function to deploy the target contract.
   * @return A target contract address
   */
  function deployContract() internal returns(address);

  /**
   * @dev Sends the contract funds to the researcher that proved the contract is broken.
   * @param target contract
   */
  function claim(Target target) {
    address researcher = researchers[target];
    if (researcher == 0) {
      throw;
    }
    // Check Target contract invariants
    if (target.checkInvariant()) {
      throw;
    }
    asyncSend(researcher, this.balance);
    claimed = true;
  }

}


/**
 * @title Target
 * @dev Your main contract should inherit from this class and implement the checkInvariant method.
 */
contract Target {

   /**
    * @dev Checks all values a contract assumes to be true all the time. If this function returns 
    * false, the contract is broken in some way and is in an inconsistent state. 
    * In order to win the bounty, security researchers will try to cause this broken state. 
    * @return True if all invariant values are correct, false otherwise. 
    */
  function checkInvariant() returns(bool);
}
