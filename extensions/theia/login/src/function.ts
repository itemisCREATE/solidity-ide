import { csvData } from './models'

const http = require('http');
const path = require('path');

const csv = require('csv-parser');
const fs = require('fs');
const sleep = require('sleep');

const stringLength: number = 50;
const validChars: string = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

export async function waitForCreation(uri: string, hash: string) {
    var repeat: boolean = true;
    while (repeat) {
        try {
            await isAvailable(uri, hash)
            console.info("geschafft");
            repeat = false;
        } catch {
            sleep.sleep(10);
        }
    }
}

async function isAvailable(uri: string, hash: string): Promise<number> {
    const redirectURI: string = uri + "/" + hash;
    let statusCode = -1;
    return new Promise((resolve, reject) => {
        http.get(redirectURI, (response) => {
            statusCode = response['statusCode'];
            if (statusCode === 200) {
                resolve();
            } else {
                reject();
            }
        });
    });
}

function randomString(): string {
    let rndStr: string = "";
    for (let i = 0; i < stringLength; i++) {
        rndStr += validChars[Math.floor(Math.random() * validChars.length)];
    }
    return rndStr;
}

function dataToString(d: csvData): string {
    return d.name + "," + d.date;
}

async function readCSV(): Promise<csvData[]> {
    return new Promise((resolve, reject) => {
        let results: csvData[] = [];
        fs.createReadStream(path.join(__dirname + '/../data.csv'))
            .pipe(csv(['name', 'date'], { separator: ',' }))
            .on('data', (data) => {
                results.push(data);
            })
            .on('end', () => {
                resolve(results);
            })
    })
}

function writeCSVrow(rowData: csvData) {
    const toWrite = dataToString(rowData) + "\n";
    fs.appendFile(path.join(__dirname + '/../data.csv'), toWrite, function (err) {
        if (err) {
            console.error(err);
        }
    });
}

async function checkCSVData(name: string): Promise<void> {
    return new Promise((resolve, reject) => {
        let csvPromise = readCSV();
        csvPromise.then((data) => {
            data.forEach((row) => {
                if (row.name === name) {
                    reject();
                }
            });
            resolve();
        });
        csvPromise.catch(() => {
            reject();
        });
    });
}

export async function handleWorkspace(): Promise<string> {
    let dataRow: csvData = {
        name: randomString(),
        date: new Date().getTime()
    };
    try {
        await checkCSVData(dataRow.name);
        writeCSVrow(dataRow);
        return Promise.resolve(dataRow.name);
    } catch {
        handleWorkspace();
    }
    return Promise.reject();
}