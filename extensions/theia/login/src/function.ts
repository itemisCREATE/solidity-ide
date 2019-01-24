const path = require('path');
const shell = require('shelljs');
const fs = require('fs');

const stringLength: number = 50;
const validChars: string = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

function randomString(): string {
    let rndStr: string = "";
    for (let i = 0; i < stringLength; i++) {
        rndStr += validChars[Math.floor(Math.random() * validChars.length)];
    }
    return rndStr;
}

export async function writeIdeJSON(ides) {
    fs.appendFile(path.join(__dirname + '/../files/ides.json'), ides.toString(), function (err) {
        if (err) {
            console.error(err);
        }
    });
}

export function handleWorkspace(): string {
    let ides = require("../files/ides.json");
    let name: string = randomString();
    while (ides.hasOwnProperty(name)) {
        name = randomString();
    }
    let date: number =  new Date().getTime();
    ides = {...ides, name:date};
    if (startContainer) {
        writeIdeJSON(ides);
        return name;
    } else {
        return undefined;
    }
}

function startContainer(name: string) {
    let runCmd: string = 'docker container run';
    runCmd += ' --name ' + name;
    runCmd += ' -p 8080:8080';
    runCmd += ' --detach';
    runCmd += ' -l traefik.enable=true';
    runCmd += ' -l traefik.docker.network=traefik';
    runCmd += ' -l traefik.port=8080';
    runCmd += ' -l ide_' + name;
    runCmd += ' -l traefik.frontend.rule=Host:solidity-ide.itemis.de;PathPrefixStrip:/' + name;
    runCmd += ' solidity-ide:latest';
    return (shell.exec(runCmd).code !== 0);
}

export function delContainer(name: string) {
    let delCmd: string = 'docker container rm -f ';
    delCmd += name;
    return (shell.exec(delCmd).code !== 0);
}