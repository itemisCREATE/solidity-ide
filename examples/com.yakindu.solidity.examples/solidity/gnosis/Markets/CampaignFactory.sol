//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Markets/Campaign.sol";


contract CampaignFactory {

    /*
     *  Events
     */
    event CampaignCreation(address indexed creator, Campaign campaign, Event eventContract, MarketFactory marketFactory, MarketMaker marketMaker, uint24 fee, uint funding, uint deadline);

    function createCampaigns(
        Event eventContract,
        MarketFactory marketFactory,
        MarketMaker marketMaker,
        uint24 fee,
        uint funding,
        uint deadline
    )
        public
        returns (Campaign campaign)
    {
        campaign = new Campaign(eventContract, marketFactory, marketMaker, fee, funding, deadline);
        CampaignCreation(msg.sender, campaign, eventContract, marketFactory, marketMaker, fee, funding, deadline);
    }
}
