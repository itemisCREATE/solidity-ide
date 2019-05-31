import * as func from './function';

const sleep = require('sleep');

const express = require('express');
const port = process.env.PORT || 4242;

const app = express();
app.use(express.json());
app.use(express.urlencoded());
app.use('/jquery', express.static(__dirname + '/node_modules/jquery/dist/'));
app.use(express.static("public"));

app.get("/workspace", (req, res) => {
  let ideName: string = func.handleWorkspace();
  if (ideName === undefined) {
    res.status(501).send("501 Internal Server Error");
  } else {
    sleep.sleep(3);
    res.redirect("/" + ideName + "/");
  }
});

app.listen(port);

console.log('RESTful API server started on: ' + port);