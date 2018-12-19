using System;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Numerics;
using Nethereum.Hex.HexTypes;
using Nethereum.ABI.FunctionEncoding.Attributes;
using Nethereum.Web3;
using Nethereum.RPC.Eth.DTOs;
using Nethereum.Contracts.CQS;
using Nethereum.Contracts.ContractHandlers;
using Nethereum.Contracts;
using System.Threading;
using Issues.Contracts.greeter.ContractDefinition;
namespace Issues.Contracts.greeter
{

    public partial class GreeterService
    {
    
        public static Task<TransactionReceipt> DeployContractAndWaitForReceiptAsync(Nethereum.Web3.Web3 web3, GreeterDeployment greeterDeployment, CancellationTokenSource cancellationTokenSource = null)
        {
            return web3.Eth.GetContractDeploymentHandler<GreeterDeployment>().SendRequestAndWaitForReceiptAsync(greeterDeployment, cancellationTokenSource);
        }
        public static Task<string> DeployContractAsync(Nethereum.Web3.Web3 web3, GreeterDeployment greeterDeployment)
        {
            return web3.Eth.GetContractDeploymentHandler<GreeterDeployment>().SendRequestAsync(greeterDeployment);
        }
        public static async Task<GreeterService> DeployContractAndGetServiceAsync(Nethereum.Web3.Web3 web3, GreeterDeployment greeterDeployment, CancellationTokenSource cancellationTokenSource = null)
        {
            var receipt = await DeployContractAndWaitForReceiptAsync(web3, greeterDeployment, cancellationTokenSource);
            return new GreeterService(web3, receipt.ContractAddress);
        }
    
        protected Nethereum.Web3.Web3 Web3{ get; }
        
        public ContractHandler ContractHandler { get; }
        
        public GreeterService(Nethereum.Web3.Web3 web3, string contractAddress)
        {
            Web3 = web3;
            ContractHandler = web3.Eth.GetContractHandler(contractAddress);
        }
    
        public Task<string> KillRequestAsync(KillFunction killFunction)
        {
             return ContractHandler.SendRequestAsync(killFunction);
        }

        public Task<string> KillRequestAsync()
        {
             return ContractHandler.SendRequestAsync<KillFunction>();
        }

        public Task<TransactionReceipt> KillRequestAndWaitForReceiptAsync(KillFunction killFunction, CancellationTokenSource cancellationToken = null)
        {
             return ContractHandler.SendRequestAndWaitForReceiptAsync(killFunction, cancellationToken);
        }

        public Task<TransactionReceipt> KillRequestAndWaitForReceiptAsync(CancellationTokenSource cancellationToken = null)
        {
             return ContractHandler.SendRequestAndWaitForReceiptAsync<KillFunction>(null, cancellationToken);
        }

        public Task<string> GreetQueryAsync(GreetFunction greetFunction, BlockParameter blockParameter = null)
        {
            return ContractHandler.QueryAsync<GreetFunction, string>(greetFunction, blockParameter);
        }

        
        public Task<string> GreetQueryAsync(BlockParameter blockParameter = null)
        {
            return ContractHandler.QueryAsync<GreetFunction, string>(null, blockParameter);
        }


    }
}
