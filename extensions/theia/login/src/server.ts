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
  func.handleWorkspace()
  .catch(() => {
    res.status(501).send();
  })
  .then((hash: string) => {
    func.waitForCreation(req.protocol + '://' + req.get('host'), hash)
    .then(() => res.redirect("/" + hash));
  });
})

app.listen(port);

console.log('RESTful API server started on: ' + port);