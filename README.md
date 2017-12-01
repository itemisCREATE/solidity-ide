# YAKINDU Solidity IDE

The free to use, open source YAKINDU Solidity IDE provides an integrated development environment for ethereum / solidity based smart contracts. 

It features all the goodies you can expect from a professional IDE including code completion, quick fixes, outline, navigation, semantic highlighting, compiler integration, and more. 

Being Eclipse based YAKINDU Solidity IDE can easily integrate into you existing toolchain.   

## Professional Support
Need professional support for YAKINDU Solidity IDE? Contact us: yakindu@itemis.com

## License
The source code of YAKINDU Solidity IDE is provided under the Eclipse Public License.

Note that YAKINDU Solidity IDE is in early beta state and we give no warranty on the correctness of any output it produces. If you find a bug or have a feature request please use our issue tracker to report it. 

## Download & Installation
In addition to the source code provided here on GitHub we also provide ready-tu-use builds for Windows and  Linux  (OS X is under construction) along with an Eclipse update site. If you just want to use YAKINDU Solidity IDE we strongly recommend to go this way.
Download a package from our download page <LINK>.
Follow the installation instructions <LINK>.

## How to Contribute
We appreciate any feedback and there are various ways to contribute feedback:
Report bugs and request features in our issue tracker.
get the source code (see below) - fork it - work on it - and provide pull requests ...

### Build everything from source
If you are familiar with Eclipse plugin development then you may want to checkout the source, setup the development environment, and start working with it. In this case you have the options described below.

### How to setup your developer workspace
1. Download Eclipse Oxygen from https://www.eclipse.org/downloads/
2. Install the current Xtext release -> Help / Install new Software / select 'Oxygen - http://download.eclipse.org/releases/oxygen' 2.1 Select Modeling / Xtext Complete SDK
3. Select the Git perspective and clone the following Git Repository: https://github.com/Yakindu/solidity-ide.git Select 'Import projects' on the 'working directory' subfolder
4. Set the target platform to com.yakindu.solidity.target Open the target file and click on the link for setting the target platform (takes some minutes the first time)
5. Build Xtext grammar right click on com.yakindu.solidity. GenerateSolidity.mwe2 => Run As.. => MWE2 Workflow
After these steps all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application

# Thanks
