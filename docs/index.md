# YAKINDU Solidity Tools

YAKINDU Solidity IDE is a solidity editor, that provides most of the features we all know and are used to from modern IDEs, including context sensitive help and code proposals, quick fixes, refactorings, templates and live validation.
The source code of YAKINDU Solidity IDE is provided under the Eclipse Public License. Note that YAKINDU Solidity IDE is in beta state and we give no warranty on the correctness of any output it produces. If you find a bug or have a feature request please use our issue tracker to report it. 

## Download & Installation

In addition to the source code provided here on GitHub, we also provide ready-to-use builds for Windows (Linux and OS X is under construction) along with an Eclipse update site. If you just want to use YAKINDU Solidity IDE we strongly recommend to go this way.

[Download all-in-one distribution here](https://info.itemis.com/yakindu/solidity/download/ "YAKINDU Solidity Tools download")

Or install via update site into latest Eclipse:
https://updates.yakindu.com/solidity/milestones

## How to Contribute
We appreciate feedback of any kind and there are various ways to do so:
 * Report bugs and request features in our issue tracker
 * Follow [@yakindu](https://twitter.com/yakindu) on twitter and spread the word about this project.
 * Get the source code (see below) - fork it - work on it - and provide pull requests ...

# Editor Features
YAKINDU Solidity Tools features all the goodies you can expect from a professional IDE, including:
## Code Completion
 In contrast to languages like JavaScript, Solidity is statically-typed. This is good news for the language engineers who want to build tooling. If the type of a referenced element is known, it is relatively easy to evaluate all possible calls on that element. For example, when I type `msg.` and press [CTRL+space], the type inferrer infers the type of `msg` which allows the IDE to provide a list of all the properties and features that are defined on that type. The same, of course, applies to more sophisticated examples.
 
![Code Completion](https://cdn-images-1.medium.com/max/800/1*suh-p7fapC2NjX5Fhk7Unw.gif)

## Quick Fixes
 Solidity is bleeding-edge technology, best practises change frequently, even syntax changes are common in new versions. Quick fixes can help to resolve issues, which are reported from the IDE or from the Soldity compiler, fast and reliably. We implemented an initial set of quick fixes that resolve simple SOLC warnings like “No visibility specified”. More sophisticated quick fixes are to come.
 
![Quick Fixes](https://cdn-images-1.medium.com/max/800/1*QHIHgHGLgcP1MZqBpUEr9A.gif)
 
## Code Navigation
 Code navigation is a handy feature to quickly jump to a function or variable declaration defined at another location in the program. In Eclipse-based tooling, this is usually done with [CTRL + click]. However, this feature is not only about comfort – it also helps a lot when trying to understand a language's scoping and shadowing rules. When mixing function overloading, extension methods and multiple inheritance, it can be quite hard to understand which function is actually called. Code navigation is a nice little helper in such situations.
 
![Code Completion](https://cdn-images-1.medium.com/max/800/1*7EjBdR4XrCbqMU0GrD_NDw.gif)
  
## Code Formatting
Code formatting is always a matter of taste. In the Solidity documentation, there is a large section on how to format your source code. Well, the style guide would have been different if I had written it. (I prefer tabs over spaces :-)) Anyways, as long as it is not only you who is working on some piece of code, it is crucial to agree on a common code style. Diffing and merging code with disparate formatting is no fun at all. Thus, an automatic code formatter that formats your code according to the Solidity style guide after pressing [CTRL + SHIFT + F] can save you a lot of time.

![Code Completion](https://cdn-images-1.medium.com/max/800/1*FTou79dllRwtfOqy8pEkPg.gif)
## Misc
 * templates
 * rename refactoring
 * live validation
 * outline
 * semantic highlighting
 * solidity compiler integration
 * and much more!

# Future work
This is not the end of our efforts to make smart contract development better. This is what we plan to do in the next year:

![Roadmap](https://pbs.twimg.com/media/DiOzdZ3W0AENFDq.jpg)

## YAKINDU Statechart Tools Integration
When examining various smart contracts it became somehow obvious that most of the contracts are basically a description of "who is allowed to do what, under which circumstances" which is in fact a very simple description of a state machine. Calling a method on such is nothing else than an incoming event on a state. 
We started to integrate YAKINDU SCT with YAKINDU Solidity IDE. This basically means that we can access built-in features of Solidity like implicitly globally available variables, constants and functions while modeling our statechart. Once the user is satisfied with his model, and have performed the necessary verifications, we can generate the solidity code, EVM byte code and ABI with a single button press. 

TBD: Image, animated gif

## Langage Server Protocol 

TBD

## Who is behind YAKINDU Solidity Tools? 

![itemis](https://www.itemis.com/hs-fs/hubfs/Corporate_Website/Logo-pur.png?t=1533137380606&width=130&name=Logo-pur.png)

YAKINDU Solidity Tools is developed and driven by developers of itemis AG, a well-known consulting company specialized on model-based development and language engineering. The YAKINDU Solidity Tools are currently developed by

 * Florian Antony (@FlorianAntony)
  TBD
 * Andreas Mülder (@andreasmuelder)
  Andreas works as a principal software engineer at itemis AG in Lünen, Germany. He is especially interested in Eclipse modeling technologies and technical project lead of the open source project YAKINDU Statechart tools. For more information, visit http://www.statecharts.org
  
 * Karten Thoms (@kthoms)
 TBD









