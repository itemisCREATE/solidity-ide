//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Markets/MarketFactory.sol";
import "../Markets/StandardMarket.sol";


contract StandardMarketFactory is MarketFactory {

    function createMarket(Event eventContract, MarketMaker marketMaker, uint24 fee)
        public override
        returns (Market market)
    {
        market = new StandardMarket(msg.sender, eventContract, marketMaker, fee);
        MarketCreation(msg.sender, market, eventContract, marketMaker, fee);
    }
}
