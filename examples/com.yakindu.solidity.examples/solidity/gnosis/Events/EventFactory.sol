//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Events/CategoricalEvent.sol";
import "../Events/ScalarEvent.sol";

contract EventFactory {

    event CategoricalEventCreation(address indexed creator, CategoricalEvent categoricalEvent, Token collateralToken, Oracle oracle, uint8 outcomeCount);
    event ScalarEventCreation(address indexed creator, ScalarEvent scalarEvent, Token collateralToken, Oracle oracle, int lowerBound, int upperBound);

    mapping (bytes32 => CategoricalEvent) public categoricalEvents;
    mapping (bytes32 => ScalarEvent) public scalarEvents;

    function createCategoricalEvent(
        Token collateralToken,
        Oracle oracle,
        uint8 outcomeCount
    )
        public
        returns (CategoricalEvent eventContract)
    {
        bytes32 eventHash = keccak256(abi.encodePacked(collateralToken, oracle, outcomeCount));
        // Event should not exist yet
        require(address(categoricalEvents[eventHash]) == address(0));
        // Create event
        eventContract = new CategoricalEvent(
            collateralToken,
            oracle,
            outcomeCount
        );
        categoricalEvents[eventHash] = eventContract;
        CategoricalEventCreation(msg.sender, eventContract, collateralToken, oracle, outcomeCount);
    }

    function createScalarEvent(
        Token collateralToken,
        Oracle oracle,
        int lowerBound,
        int upperBound
    )
        public
        returns (ScalarEvent eventContract)
    {
        bytes32 eventHash = keccak256(abi.encodePacked(collateralToken, oracle, lowerBound, upperBound));
        require(address(scalarEvents[eventHash]) == address(0));
        eventContract = new ScalarEvent(
            collateralToken,
            oracle,
            lowerBound,
            upperBound
        );
        scalarEvents[eventHash] = eventContract;
        ScalarEventCreation(msg.sender, eventContract, collateralToken, oracle, lowerBound, upperBound);
    }
}
