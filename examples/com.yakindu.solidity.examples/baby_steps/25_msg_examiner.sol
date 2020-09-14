//SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.10 ;
contract msgExaminer {

    address payable creator;
    address payable miner;
  
    bytes contract_creation_data;
    uint contract_creation_gas;
    uint contract_creation_value;
    uint contract_creation_tx_gasprice;
    address contract_creation_tx_origin;

	constructor () payable public {
        creator = msg.sender; 								// msg is a global variable
       
        contract_creation_data = msg.data;
        contract_creation_gas = gasleft();
        contract_creation_value = msg.value;  				// the endowment of this contract in wei 
        
        contract_creation_tx_gasprice = tx.gasprice;
        contract_creation_tx_origin = tx.origin;
    }
	
	function getContractCreationData() view public returns (bytes memory) 		
    {										              			
    	return contract_creation_data;
    }
	
	function getContractCreationGas() view public returns (uint) 	// returned 732117 for me. Must be the gas expended 
    {										              		// the creation of this contract. msg.gas should be msg.gasExpended	
    	return contract_creation_gas;
    }
	
    function getContractCreationValue() view public returns (uint) // returns the original endowment of the contract
    {										              		// set at creation time with "value: <someweivalue>"	
    	return contract_creation_value;                         // this is now the "balance" of the contract
    }
    
    function getContractCreationTxGasprice() view public returns (uint) // returned 50000000000 for me. Must be the gasprice 	
    {											     				 // the sender is willing to pay. msg.gasPrice should be msg.gasLimit
    	return contract_creation_tx_gasprice;
    }
    
    function getContractCreationTxOrigin() view public returns (address) // returned my coinbase address.
    {											     				  //  Not sure if a chain of transactions would return the same.
    	return contract_creation_tx_origin;
    }
    
    bytes msg_data_before_creator_send;
    bytes msg_data_after_creator_send;
    uint msg_gas_before_creator_send;
    uint msg_gas_after_creator_send;
  	uint msg_value_before_creator_send;
    uint msg_value_after_creator_send;
    
    function sendOneEtherToMiner() payable public returns (bool success)      	
    {						
    	msg_gas_before_creator_send = gasleft();			// save msg values
    	msg_data_before_creator_send = msg.data;	
    	msg_value_before_creator_send = msg.value;			  
    	bool returnval = miner.send(1000000000000000000);				// do something gassy
    	msg_gas_after_creator_send = gasleft();			// save them again
    	msg_data_after_creator_send = msg.data;
    	msg_value_after_creator_send = msg.value;		// did anything change? Use getters below.
    	return returnval;
    }
    
    function sendOneEtherToHome() payable public returns (bool success)         	
    {						
    	msg_gas_before_creator_send = gasleft();			// save msg values
    	msg_data_before_creator_send = msg.data;	
    	msg_value_before_creator_send = msg.value;			  
    	bool returnval = creator.send(1000000000000000000);				// do something gassy
    	msg_gas_after_creator_send = gasleft();			// save them again
    	msg_data_after_creator_send = msg.data;
    	msg_value_after_creator_send = msg.value;		// did anything change? Use getters below.
    	return returnval;
    }
    
    
    function getMsgDataBefore() view public returns (bytes memory)          
    {						
    	return msg_data_before_creator_send;							  
    }
    
    function getMsgDataAfter() view public returns (bytes memory)         
    {						
    	return msg_data_after_creator_send;							  
    }
    
    
    function getMsgGasBefore() view public returns (uint)          
    {						
    	return msg_gas_before_creator_send;							  
    }
    
    function getMsgGasAfter() view public returns (uint)         
    {						
    	return msg_gas_after_creator_send;							  
    }
    
   
    function getMsgValueBefore() view public returns (uint)          
    {						
    	return msg_value_before_creator_send;							  
    }
    
    function getMsgValueAfter() view public returns (uint)         
    {						
    	return msg_value_after_creator_send;							  
    }
 
 
    
    /**********
     Standard kill() function to recover funds 
     **********/
    
    function kill() public
    { 
        if (msg.sender == creator)
            selfdestruct(creator);  // kills this contract and sends remaining funds back to creator
    }
        
}
