//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.6.10;
import "../Oracles/Oracle.sol";
import "../Tokens/Token.sol";
import "../Utils/Math.sol";


contract UltimateOracle is Oracle {
    using Math for *;

    /*
     *  Events
     */
    event ForwardedOracleOutcomeAssignment(int outcome);
    event OutcomeChallenge(address indexed sender, int outcome);
    event OutcomeVote(address indexed sender, int outcome, uint amount);
    event Withdrawal(address indexed sender, uint amount);

    /*
     *  Storage
     */
    Oracle public forwardedOracle;
    Token public collateralToken;
    uint8 public spreadMultiplier;
    uint public challengePeriod;
    uint public challengeAmount;
    uint public frontRunnerPeriod;

    int public forwardedOutcome;
    uint public forwardedOutcomeSetTimestamp;
    int public frontRunner;
    uint public frontRunnerSetTimestamp;

    uint public totalAmount;
    mapping (int => uint) public totalOutcomeAmounts;
    mapping (address => mapping (int => uint)) public outcomeAmounts;

	constructor (
        Oracle _forwardedOracle ,
        Token _collateralToken ,
        uint8 _spreadMultiplier ,
        uint _challengePeriod ,
        uint _challengeAmount ,
        uint _frontRunnerPeriod
    ) public {
        // Validate inputs
        require(   address(_forwardedOracle) != 0
                && address(_collateralToken) != 0
                && _spreadMultiplier >= 2
                && _challengePeriod > 0
                && _challengeAmount > 0
                && _frontRunnerPeriod > 0);
        forwardedOracle = _forwardedOracle;
        collateralToken = _collateralToken;
        spreadMultiplier = _spreadMultiplier;
        challengePeriod = _challengePeriod;
        challengeAmount = _challengeAmount;
        frontRunnerPeriod = _frontRunnerPeriod;
    }

    function setForwardedOutcome()
        public
    {
        // There was no challenge and the outcome was not set yet in the ultimate oracle but in the forwarded oracle
        require(   !isChallenged()
                && forwardedOutcomeSetTimestamp == 0
                && forwardedOracle.isOutcomeSet());
        forwardedOutcome = forwardedOracle.getOutcome();
        forwardedOutcomeSetTimestamp = now;
        ForwardedOracleOutcomeAssignment(forwardedOutcome);
    }

    function challengeOutcome(int _outcome)
        public
    {
        // There was no challenge yet or the challenge period expired
        require(   !isChallenged()
                && !isChallengePeriodOver()
                && collateralToken.transferFrom(msg.sender, address(this), challengeAmount));
        outcomeAmounts[msg.sender][_outcome] = challengeAmount;
        totalOutcomeAmounts[_outcome] = challengeAmount;
        totalAmount = challengeAmount;
        frontRunner = _outcome;
        frontRunnerSetTimestamp = now;
        OutcomeChallenge(msg.sender, _outcome);
    }

    function voteForOutcome(int _outcome, uint amount)
        public
    {
        uint maxAmount = (totalAmount - totalOutcomeAmounts[_outcome]) ;
		mul(spreadMultiplier);
        if (amount > maxAmount)
            amount = maxAmount;
        require(   isChallenged()
                && !isFrontRunnerPeriodOver()
                && collateralToken.transferFrom(msg.sender, address(this), amount));
        outcomeAmounts[msg.sender][_outcome] = outcomeAmounts[msg.sender][_outcome].add(amount);
        totalOutcomeAmounts[_outcome] = totalOutcomeAmounts[_outcome].add(amount);
        totalAmount = totalAmount.add(amount);
        if (_outcome != frontRunner && totalOutcomeAmounts[_outcome] > totalOutcomeAmounts[frontRunner])
        {
            frontRunner = _outcome;
            frontRunnerSetTimestamp = now;
        }
        OutcomeVote(msg.sender, _outcome, amount);
    }

    function withdraw()
        public
        returns (uint amount)
    {
        // Outcome was challenged and ultimate outcome decided
        require(isFrontRunnerPeriodOver());
        amount = totalAmount.mul(outcomeAmounts[msg.sender][frontRunner]) / totalOutcomeAmounts[frontRunner];
        outcomeAmounts[msg.sender][frontRunner] = 0;
        // Transfer earnings to contributor
        require(collateralToken.transfer(msg.sender, amount));
        Withdrawal(msg.sender, amount);
    }

    function isChallengePeriodOver()
        public
        returns (bool)
    {
        return forwardedOutcomeSetTimestamp != 0 && now.sub(forwardedOutcomeSetTimestamp) > challengePeriod;
    }

    function isFrontRunnerPeriodOver()
        public
        returns (bool)
    {
        return frontRunnerSetTimestamp != 0 && now.sub(frontRunnerSetTimestamp) > frontRunnerPeriod;
    }

    function isChallenged()
        public
        returns (bool)
    {
        return frontRunnerSetTimestamp != 0;
    }

    function isOutcomeSet()
        public override
        returns (bool)
    {
        return    isChallengePeriodOver() && !isChallenged()
               || isFrontRunnerPeriodOver();
    }

    function getOutcome()
        public override
        returns (int)
    {
        if (isFrontRunnerPeriodOver())
            return frontRunner;
        return forwardedOutcome;
    }
}



