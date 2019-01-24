import * as func from './function';

const sleep = require('sleep');

async function checkIdeJSON(): Promise<void> {
    return new Promise((resolve) => {
        let ides = require("../files/ides.json");
        for (let name in ides) {
            if (ides[name] > (new Date().getTime()-(60*60*1000))) {
                delete ides[name];
                func.delContainer(name);
            }
        }
        func.writeIdeJSON(ides);
        resolve();
    });
}

async function loop() {
    while(true) {
        await checkIdeJSON();
        sleep.sleep(600);
    }
}

loop();