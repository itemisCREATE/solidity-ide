const csv = require('csv-parser');
const fs= require('fs');
const sleep = require('sleep');

interface csvData{
    name: string;
    date: number;
}

function dataToString(d: csvData) : string {
  return d.name + "," + d.date + "\n";
}

async function checkCSVData(): Promise<void> {
    return new Promise((resolve) => {
        var csvContent: string = "";
        fs.createReadStream('data.csv')
            .pipe(csv(['name', 'date'], { separator: ',' }))
            .on('data', (data) => {
                if (data.date > (new Date().getTime()-(60*60*1000))) {
                    csvContent += dataToString(data);
                }
            })
            .on('end', () => {
                fs.writeFile('data.csv', csvContent, function () {
                    console.log('Clean Up!');
                    resolve();
            });
        });
    });
}

async function loop() {
    while(true) {
        await checkCSVData();
        sleep.sleep(600);
    }
}

loop();