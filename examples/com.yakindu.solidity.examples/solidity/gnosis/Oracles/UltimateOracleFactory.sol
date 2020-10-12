//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/UltimateOracle.sol";


/// @title Ultimate oracle factory contract - Allows to create ultimate oracle contracts
/// @author Stefan George - <stefan@gnosis.pm>
contract UltimateOracleFactory {

    /*
     *  Events
     */
    event UltimateOracleCreation(
        address indexed creator,
        UltimateOracle ultimateOracle,
        Oracle oracle,
        Token collateralToken,
        uint8 spreadMultiplier,
        uint challengePeriod,
        uint challengeAmount,
        uint frontRunnerPeriod
    );

    /*
     *  Public functions
     */
    function createUltimateOracle(
        Oracle oracle,
        Token collateralToken,
        uint8 spreadMultiplier,
        uint challengePeriod,
        uint challengeAmount,
        uint frontRunnerPeriod
    )
        public
        returns (UltimateOracle ultimateOracle)
    {
        ultimateOracle = new UltimateOracle(
            oracle,
            collateralToken,
            spreadMultiplier,
            challengePeriod,
            challengeAmount,
            frontRunnerPeriod
        );
        UltimateOracleCreation(
            msg.sender,
            ultimateOracle,
            oracle,
            collateralToken,
            spreadMultiplier,
            challengePeriod,
            challengeAmount,
            frontRunnerPeriod
        );
    }
}
