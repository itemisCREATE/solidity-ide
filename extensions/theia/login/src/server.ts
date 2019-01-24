import * as func from './function';

const express = require('express');
const path = require('path');
const port = process.env.PORT || 4242;

const app = express();
app.use(express.json());
app.use(express.urlencoded());
app.use('/jquery', express.static(__dirname + '/node_modules/jquery/dist/'));
app.use(express.static("public"));

app.get("/workspace", (req, res) => {
  let ideName: string = func.handleWorkspace();
  if (ideName === undefined) {
    res.status(501).send();
  } else {
    res.redirect("/" + ideName);
  }
});

app.listen(port);

console.log('RESTful API server started on: ' + port);