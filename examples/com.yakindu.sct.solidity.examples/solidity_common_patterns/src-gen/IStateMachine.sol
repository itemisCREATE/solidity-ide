pragma solidity ^0.4.18;

import 'StateMachineState';
contract StateMachine {

	address state;
	
	function StateMachine (){
		// TODO
		state = new StateMachineState(); 
	}
	
}
