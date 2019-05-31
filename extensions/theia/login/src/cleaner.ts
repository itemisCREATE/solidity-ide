import * as func from './function';

const sleep = require('sleep');

async function checkIdeJSON(): Promise<void> {
    return new Promise((resolve) => {
        let ides = func.getIDEs();
        for (let name in ides) {
            if (ides[name] < (new Date().getTime()-(60*60*1000))) {
                func.delIDE(name);
            }
        }
        func.writeIDEs();
        resolve();
    });
}

async function loop() {
    while(true) {
        sleep.sleep(600);
        await checkIdeJSON();
    }
}

function startUpClean(){
    let ides = func.getIDEs();
    for (let name in ides) {
        func.delIDE(name);
    }
    func.writeIDEs();
    loop();
}

startUpClean();