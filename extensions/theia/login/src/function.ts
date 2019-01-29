const path = require('path');
const shell = require('shelljs');
//const fs = require('fs');

let ides = require("../files/ides.json");

shell.config.fatal = true;
shell.config.silent = true;

const stringLength: number = 50;
const validChars: string = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

function randomString(): string {
    let rndStr: string = "";
    for (let i = 0; i < stringLength; i++) {
        rndStr += validChars[Math.floor(Math.random() * validChars.length)];
    }
    return rndStr;
}

export function getIDEs() {
    return ides;
}

export function delIDE(name: string) {
    delete ides[name];
    delContainer(name);
}

export async function writeIDEs() {
    shell.echo(JSON.stringify(ides)).to(__dirname + '/../files/ides.json');
}

export function handleWorkspace(): string {
    let name: string = randomString();
    while (ides.hasOwnProperty(name)) {
        name = randomString();
    }
    let date: number =  new Date().getTime();
    ides[name] = date;
    // if (startContainer(name)) {
        startContainer(name)
        writeIDEs();
        return name;
    // } else {
    //     return undefined;
    // }
}

function startContainer(name: string) {
    let runCmd: string = 'docker container run';
    runCmd += ' --name ' + name;
    runCmd += ' --detach';
    runCmd += ' -l "traefik.enable=true"';
    runCmd += ' -l "traefik.docker.network=traefik"';
    runCmd += ' -l "traefik.port=8080"';
    runCmd += ' -l "traefik.backend=ide_' + name + '"';
    runCmd += ' -l "traefik.frontend.rule=Host:solidity-ide.itemis.de;PathPrefixStrip:/' + name + '"';
    runCmd += ' solidity-ide:latest';
    shell.exec(runCmd);
}

function delContainer(name: string) {
    let delCmd: string = 'docker container rm -f ';
    delCmd += name;
    shell.exec(delCmd);
}