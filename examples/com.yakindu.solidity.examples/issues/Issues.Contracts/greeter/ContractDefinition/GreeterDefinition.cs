using System;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Numerics;
using Nethereum.Hex.HexTypes;
using Nethereum.ABI.FunctionEncoding.Attributes;
using Nethereum.Web3;
using Nethereum.RPC.Eth.DTOs;
using Nethereum.Contracts.CQS;
using Nethereum.Contracts;
using System.Threading;
namespace Issues.Contracts.greeter.ContractDefinition
{
    
    
    public partial class GreeterDeployment:GreeterDeploymentBase
    {
        public GreeterDeployment():base(BYTECODE) { }
        
        public GreeterDeployment(string byteCode):base(byteCode) { }
    }

    public class GreeterDeploymentBase:ContractDeploymentMessage
    {
        
        public static string BYTECODE = "608060405234801561001057600080fd5b506040516102ec3803806102ec83398101604052805160008054600160a060020a0319163317905501805161004c906001906020840190610053565b50506100ee565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061009457805160ff19168380011785556100c1565b828001600101855582156100c1579182015b828111156100c15782518255916020019190600101906100a6565b506100cd9291506100d1565b5090565b6100eb91905b808211156100cd57600081556001016100d7565b90565b6101ef806100fd6000396000f30060806040526004361061004b5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610050578063cfae321714610067575b600080fd5b34801561005c57600080fd5b506100656100f1565b005b34801561007357600080fd5b5061007c61012e565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100b657818101518382015260200161009e565b50505050905090810190601f1680156100e35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60005473ffffffffffffffffffffffffffffffffffffffff1633141561012c5760005473ffffffffffffffffffffffffffffffffffffffff16ff5b565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156101b95780601f1061018e576101008083540402835291602001916101b9565b820191906000526020600020905b81548152906001019060200180831161019c57829003601f168201915b50505050509050905600a165627a7a723058201cb46ddf0b29174825be5051406c4c0b8f9354bd04417394aa8390bcfa22c2950029";
        
        public GreeterDeploymentBase():base(BYTECODE) { }
        
        public GreeterDeploymentBase(string byteCode):base(byteCode) { }
        
        [Parameter("string", "_greeting", 1)]
        public virtual string Greeting {get; set;}
    }    
    
    public partial class KillFunction:KillFunctionBase{}

    [Function("kill")]
    public class KillFunctionBase:FunctionMessage
    {

    }    
    
    public partial class GreetFunction:GreetFunctionBase{}

    [Function("greet", "string")]
    public class GreetFunctionBase:FunctionMessage
    {

    }    
    
    
    
    public partial class GreetOutputDTO:GreetOutputDTOBase{}

    [FunctionOutput]
    public class GreetOutputDTOBase :IFunctionOutputDTO 
    {
        [Parameter("string", "", 1)]
        public virtual string ReturnValue1 {get; set;}
    }
}
