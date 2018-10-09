[![Build Status](https://travis-ci.org/Yakindu/solidity-ide.svg?branch=master)](https://travis-ci.org/Yakindu/solidity-ide)

# YAKINDU Solidity Tools

[Visit our website here](https://yakindu.github.io/solidity-ide/ "YAKINDU Solidity Tools website")

[Download all-in-one distribution here](https://info.itemis.com/yakindu/solidity/download/ "YAKINDU Solidity Tools download")

The free to use, open source YAKINDU Solidity Tools provides an integrated development environment for ethereum / solidity based smart contracts. 

It features all the goodies you can expect from a professional IDE, including
 * code completion
 * quick fixes
 * templates
 * live validation
 * outline
 * code navigation
 * semantic highlighting
 * solidity compiler integration
 * and much more!

As an Eclipse based IDE, YAKINDU Solidity Tools can easily be integrated into your existing toolchain.   

![Image of YAKINDU Solidity Tools](https://github.com/Yakindu/solidity-ide/blob/master/screenshot.png)


## License
The source code of YAKINDU Solidity Tools is provided under the Eclipse Public License.

Note that YAKINDU Solidity Tools is in early beta state and we give no warranty on the correctness of any output it produces. If you find a bug or have a feature request please use our issue tracker to report it. 

## Download & Installation
In addition to the source code provided here on GitHub we also provide ready-to-use builds for Windows (Linux and OS X is under construction) along with an Eclipse update site. If you just want to use YAKINDU Solidity Tools we strongly recommend to go this way.

Download a package from our download page:
https://info.itemis.com/yakindu/solidity/download/

Or install via update site into latest Eclipse:
https://updates.yakindu.com/solidity/milestones

## How to Contribute
We appreciate feedback of any kind and there are various ways to do so:
 * Report bugs and request features in our issue tracker
 * Follow [@yakindu](https://twitter.com/yakindu) on twitter and spread the word about this project.
 * Get the source code (see below) - fork it - work on it - and provide pull requests ...

### Build everything from source
If you are familiar with Eclipse plugin development then you may want to checkout the source, setup the development environment, and start working with it. In this case you have the options described below.

### How to setup your developer workspace
1. Download Eclipse Oxygen from https://www.eclipse.org/downloads/
2. Install the current Xtext release: Help / Install new Software / select 'Oxygen - http://download.eclipse.org/releases/oxygen' / Select Modeling / Xtext Complete SDK
3. Clone this Git Repo: Activate the Git perspective and clone the following Git Repository: https://github.com/Yakindu/solidity-ide.git /  Select 'Import projects' on the 'working directory' subfolder
4. Set target platform: Open the target file in project com.yakindu.solidity.target / click on the link to set the target platform (takes some minutes the first time)
5. Build Xtext grammar: Right click on com.yakindu.solidity.GenerateSolidity.mwe2 => Run As.. => MWE2 Workflow

After these steps all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application
