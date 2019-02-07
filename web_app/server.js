const express = require("express");
const request = require("request");
const app = express();
const PORT = 5000;

app.get("/", (req, res) => {
  res.send("Hello!");
});

app.get("/todos", (req, res) => {
  request.get(process.env.TODO_URL, (error, response, body) => {
    res.send(response.body);
  });
});

app.listen(PORT, () => console.log(`App listening on port ${PORT}`));
