const {AutoLanguageClient} = require('atom-languageclient')
const path = require("path");
const os = require("os");
const { spawn } = require('child_process');

class SolidityLanguageClient extends AutoLanguageClient {
  getGrammarScopes () { return [ 'source.sol' ] }
  getLanguageName () { return 'Solidity' }
  getServerName () { return 'Solidity Language Server' }
  getConnectionType() { return 'stdio' }
  startServerProcess () {
    let launcher = os.platform() === 'win32' ? 'solidity-ls.bat' : 'solidity-ls'
    let lsDir = atom.packages.resolvePackagePath(path.join(__dirname, "ls", "bin"))
    return spawn(path.join(lsDir, launcher));
  }
}

var server = new SolidityLanguageClient()
module.exports = server
