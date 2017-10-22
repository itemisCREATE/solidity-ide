pragma solidity ^0.4.18;
contract StateMachine {
    enum States {
    	StateMachine_main_region_AcceptingBlindedBids,
    	StateMachine_main_region_RevealBids,
    	StateMachine_main_region_AnotherState,
    	StateMachine_main_region_AreWeDoneYet,
    	StateMachine_main_region_Finished
    }
    
    Events private lastEvent = Events.nullEvent;
    
    enum Events {
    	bid,
    	reveal,
    	g,
    	h,
    	i
    , nullEvent}
    // This is the current state.
    States public activeState = States.StateMachine_main_region_AcceptingBlindedBids;
    
    address private owner; 
function bid() public react {
	lastEvent = Events.bid;
}	
function reveal() public react {
	lastEvent = Events.reveal;
}	
function g() public react {
	lastEvent = Events.g;
}	
function h() public react {
	lastEvent = Events.h;
}	
function i() public react {
	lastEvent = Events.i;
}	
uint public creationTime=block.timestamp;

    modifier exit() {
	    _;
    }

	modifier entry() {
		_;
    }

	modifier react() {
		_;
		if(activeState == States.StateMachine_main_region_AcceptingBlindedBids){
				if ((true) && (block.timestamp >= creationTime + 10)) {
				}
		}else 
		if(activeState == States.StateMachine_main_region_RevealBids){
				if ((true) && (block.timestamp >= creationTime + 12)) {
				}
		}else 
		if(activeState == States.StateMachine_main_region_AnotherState){
		}else 
		if(activeState == States.StateMachine_main_region_AreWeDoneYet){
		}
	}
	
	
	function StateMachineStatemachine()public {
		owner = msg.sender;
	}
	
	function() public payable {
		
	}
}
