//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/FutarchyOracle.sol";


contract FutarchyOracleFactory {

    /*
     *  Events
     */
    event FutarchyOracleCreation(
        address indexed creator,
        FutarchyOracle futarchyOracle,
        Token collateralToken,
        Oracle oracle,
        uint8 outcomeCount,
        int lowerBound,
        int upperBound,
        MarketFactory marketFactory,
        MarketMaker marketMaker,
        uint24 fee,
        uint deadline
    );

    /*
     *  Storage
     */
    EventFactory eventFactory;

	constructor (EventFactory _eventFactory) public {
        require(address(_eventFactory) != address(0));
        eventFactory = _eventFactory;
    }

    function createFutarchyOracle(
        Token collateralToken,
        Oracle oracle,
        uint8 outcomeCount,
        int lowerBound,
        int upperBound,
        MarketFactory marketFactory,
        MarketMaker marketMaker,
        uint24 fee,
        uint deadline
    )
        public
        returns (FutarchyOracle futarchyOracle)
    {
        futarchyOracle = new FutarchyOracle(
            msg.sender,
            eventFactory,
            collateralToken,
            oracle,
            outcomeCount,
            lowerBound,
            upperBound,
            marketFactory,
            marketMaker,
            fee,
            deadline
        );
        FutarchyOracleCreation(
            msg.sender,
            futarchyOracle,
            collateralToken,
            oracle,
            outcomeCount,
            lowerBound,
            upperBound,
            marketFactory,
            marketMaker,
            fee,
            deadline
        );
    }
}



