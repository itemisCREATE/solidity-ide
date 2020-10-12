//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";


contract MajorityOracle is Oracle {

    /*
     *  Storage
     */
    Oracle[] public oracles;

	constructor (Oracle[] memory _oracles) public {
        // At least 2 oracles should be defined
        require(_oracles.length > 2);
        for (uint i = 0; i < _oracles.length; i++)
            // Oracle address cannot be null
            require(address(_oracles[i]) != address(0));
        oracles = _oracles;
    }

    function getStatusAndOutcome()
        public
        returns (bool outcomeSet, int outcome)
    {
        uint i;
        int[] memory outcomes = new int[](oracles.length);
        uint[] memory validations = new uint[](oracles.length);
        for (i = 0; i < oracles.length; i++)
            if (oracles[i].isOutcomeSet()) {
                int _outcome = oracles[i].getOutcome();
                for (uint j = 0; j <= i; j++)
                    if (_outcome == outcomes[j]) {
                        validations[j] += 1;
                        break;
                    }
                    else if (validations[j] == 0) {
                        outcomes[j] = _outcome;
                        validations[j] = 1;
                        break;
                    }
            }
        uint outcomeValidations = 0;
        uint outcomeIndex = 0;
        for (i = 0; i < oracles.length; i++)
            if (validations[i] > outcomeValidations) {
                outcomeValidations = validations[i];
                outcomeIndex = i;
            }
        // There is a majority vote
        if (outcomeValidations * 2 > oracles.length) {
            outcomeSet = true;
            outcome = outcomes[outcomeIndex];
        }
    }

    function isOutcomeSet()
        public override
        returns (bool)
    {
        (bool outcomeSet, int outcome)= getStatusAndOutcome();
        return outcomeSet;
    }

    function getOutcome()
        public override
        returns (int)
    {
        (bool outcomeSet, int winningOutcome)= getStatusAndOutcome();
        return winningOutcome;
    }
}



