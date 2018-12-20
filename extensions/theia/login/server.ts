import * as crypto from "crypto";
import { Response } from "express";

var express = require('express'),
  path = require('path'),
  port = process.env.PORT || 4242,
  app = express();
  
app.use(express.json());
app.use(express.urlencoded()); 

const csv = require('csv-parser');
const fs = require('fs');

interface csvData{
  name: string;
  date: number;
}

function dataToString(d: csvData) : string {
  return d.name + "," + d.date;
}

async function readCSV(): Promise<csvData[]>{
  return new Promise((resolve, reject) => {
    var results: csvData[] = [];
    fs.createReadStream('data.csv')
      .pipe(csv(['name', 'date'], { separator: ',' }))
      .on('data', (data) => {
        results.push(data);
      })
      .on('end', () => {
        resolve(results);
      })
    })
}

function writeCSVrow(rowData: csvData){
  const toWrite = dataToString(rowData) + "\n";
    fs.appendFile('data.csv', toWrite, function (err) {
    if (err) {
      console.error(err);
    }
  });
}

async function checkCSVData(name: string): Promise<void> {
  return new Promise((resolve, reject) => {
    var csvPromise = readCSV();
    csvPromise.then((data) => {
      data.forEach((row) => {
        if (row.name === name) {
          resolve();
        }
      });
      reject();
    });
    csvPromise.catch(() => {
      reject();
    });
  });
}

async function handleWorkspace(res: Response, dataRow: csvData, pName: string, workspace: string){
  try {
    await checkCSVData(dataRow.name);
  } catch {
    writeCSVrow(dataRow);
    //Creation of Docker Container is handled by OS
  }
  const params: string = "workspace=" + workspace + "&pName=" + pName + "&hash=" + dataRow.name;
  res.redirect('/loading.html?' + params)
}

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname + '/index.html'));
})

app.post("/workspace", (req, res) => {
  var pName: string = req.body.projectname; //TODO handle Input Field for security
  var workspace: string = req.body.workspace; //TODO handle Input Field for security
  if (pName === undefined || pName === "") {
    res.sendFile(path.join(__dirname + '/index.html'));
  } else if (workspace === undefined || workspace === "") {
    res.sendFile(path.join(__dirname + '/index.html'));
  } else {
    var dataRow: csvData = {
      //name : crypto.SHA256(pName+workspace).,
      name : crypto.createHash('sha256').update(pName+workspace).digest('hex'),
      date : new Date().getTime(),
    };
    handleWorkspace(res, dataRow, pName, workspace);
  }
})

/app.get("/loading.js", (req, res) => {
  res.sendFile(path.join(__dirname + '/loading.js'));
})

/app.get("/loading.js.map", (req, res) => {
  res.sendFile(path.join(__dirname + '/loading.js.map'));
})

/app.get("/loading.html", (req, res) => {
  res.sendFile(path.join(__dirname + '/loading.html'));
})

app.get("/propeller", (req, res) => {
  res.sendFile(path.join(__dirname + '/Yakindu-Marke.png'));
})

app.listen(port);

console.log('RESTful API server started on: ' + port);