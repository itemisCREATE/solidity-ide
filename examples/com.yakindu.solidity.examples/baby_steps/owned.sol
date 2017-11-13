contract owned{
  function owned() {
    owner = msg.sender;
  }
  
  modifier onlyowner() {
    if(msg.sender==owner) _;
  }
  
  address owner;
}