[![Build Status](https://travis-ci.org/Yakindu/solidity-ide.svg?branch=master)](https://travis-ci.org/Yakindu/solidity-ide)

# YAKINDU Solidity Tools

[Download all-in-one distribution here](https://info.itemis.com/yakindu/solidity/download/ "YAKINDU Solidity Tools download")

The free to use, open source YAKINDU Solidity IDE provides an integrated development environment for ethereum / solidity based smart contracts. 
# Features
It features all the goodies you can expect from a professional IDE, including
## code completion
 In contrast to languages like JavaScript, Solidity is a statically-typed language. This is good news for the language engineers who want to build tooling. If the type of a referenced element is known, it is relatively easy to evaluate all possible calls on that element. For example, in case of Solidity if I type msg. and press [CTRL+space], the parser knows the type of msg and I can show up a list of proposals that contain the properties and features that can be used on this type. the same, of course applies to more sophisticated examples.
![Code Completion](https://cdn-images-1.medium.com/max/800/1*suh-p7fapC2NjX5Fhk7Unw.gif)
## quick fixes
 Solidity is bleeding-edge technology, best practises change frequently, even syntax changes are common in new versions. Quick fixes can help to resolve issues, which are reported from the IDE or from the Soldity compiler, fast and reliably. We implemented an initial set of quick fixes that resolve simple SOLC warnings like “No visibility specified”. More sophisticated quick fixes are to come.
 ![Code Completion](https://cdn-images-1.medium.com/max/800/1*QHIHgHGLgcP1MZqBpUEr9A.gif)
## Code Navigation
 Code navigation is a handy feature to quickly jump to a function or variable declaration defined at another location in the program. In Eclipse based tooling, this is usually done with [CTRL + click]. However, this feature is not only about comfort – it also helps a lot when trying to understand a languages scoping and shadowing rules. When mixing function overloading, extension methods and multiple inheritance it can be quite hard to understand which function is actually called. Code Navigation is a nice little helper in such situations.
  ![Code Completion](https://cdn-images-1.medium.com/max/800/1*7EjBdR4XrCbqMU0GrD_NDw.gif)
## Code Formatting
Code formatting is always a matter of taste. In the Solidity documentation, there is a large section on how to format your source code. Well the style guide would have been different if I had written it. (I prefer tabs over spaces :-)) Anyway, as long as it is not only you who is working on some piece of code, it is crucial to agree on a common code style. Diffing and merging code with disparate formatting is no fun at all. Thus, an automatic code formatter that formats your code accordings to the Solidity style guide after pressing CTRL SHIFT + F can save you a lot of time.
  ![Code Completion](https://cdn-images-1.medium.com/max/800/1*FTou79dllRwtfOqy8pEkPg.gif)
## Misc
 * templates
 * rename refactoring
 * live validation
 * outline
 * semantic highlighting
 * solidity compiler integration
 * and much more!

# License
The source code of YAKINDU Solidity IDE is provided under the Eclipse Public License.

Note that YAKINDU Solidity IDE is in beta state and we give no warranty on the correctness of any output it produces. If you find a bug or have a feature request please use our issue tracker to report it. 

## Download & Installation
In addition to the source code provided here on GitHub we also provide ready-to-use builds for Windows (Linux and OS X is under construction) along with an Eclipse update site. If you just want to use YAKINDU Solidity IDE we strongly recommend to go this way.

Download a package from our download page:
https://info.itemis.com/yakindu/solidity/download/

Or install via update site into latest Eclipse:
https://updates.yakindu.com/solidity/milestones



## How to Contribute
We appreciate feedback of any kind and there are various ways to do so:
 * Report bugs and request features in our issue tracker
 * Follow [@yakindu](https://twitter.com/yakindu) on twitter and spread the word about this project.
 * Get the source code (see below) - fork it - work on it - and provide pull requests ...
