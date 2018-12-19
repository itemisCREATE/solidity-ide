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
namespace Issues.Contracts.mortal.ContractDefinition
{
    
    
    public partial class MortalDeployment:MortalDeploymentBase
    {
        public MortalDeployment():base(BYTECODE) { }
        
        public MortalDeployment(string byteCode):base(byteCode) { }
    }

    public class MortalDeploymentBase:ContractDeploymentMessage
    {
        
        public static string BYTECODE = "";
        
        public MortalDeploymentBase():base(BYTECODE) { }
        
        public MortalDeploymentBase(string byteCode):base(byteCode) { }
        

    }    
    
    public partial class KillFunction:KillFunctionBase{}

    [Function("kill")]
    public class KillFunctionBase:FunctionMessage
    {

    }    
    

}
