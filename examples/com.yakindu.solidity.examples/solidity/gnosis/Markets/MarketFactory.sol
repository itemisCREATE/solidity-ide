//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Events/Event.sol";
import "../MarketMakers/MarketMaker.sol";
import "../Markets/Market.sol";


abstract contract MarketFactory {

    /*
     *  Events
     */
    event MarketCreation(address indexed creator, Market market, Event eventContract, MarketMaker marketMaker, uint24 fee);

    /*
     *  Public functions
     */
    function createMarket(Event eventContract, MarketMaker marketMaker, uint24 fee) public virtual returns (Market);
}
