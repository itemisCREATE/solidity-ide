
contract Contract {
    
    event E(address a);

    function f(){
       
        Contract c = new Contract();
        
        E(c); // error: Incompatible Types    
         
        E(new Contract()); // OK   
    } 

} 