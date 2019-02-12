const express = require("express");
const request = require("request");
const app = express();
const PORT = 3000;
const TODO_DNS = process.env.TODO_DNS;

app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => res.send(
  `<p>Hello<p>`
));

app.get('/todos', (req, res) =>  {
  const form = "</p><form action='/todos' method='post'> <input name='details' type='text'>" +
    "<button> save </button></form>"
  const URL = TODO_DNS+"/todos";
  request.get(URL,(err,response,body)=>{
    if(err) return console.log(err);
    const content = `${form}<br/><br/>${body}`;
    res.send(content);
  })
});

app.post('/todos', (req, res) =>  {
  const URL = TODO_DNS+"/todos";
  request.post(URL,
    {json:{ details: req.body.details }},
    function(error, response, body){
      if(error)console.log(error);
      res.redirect('/todos');
    });
});

app.listen(PORT, () => console.log(`App listening on port ${PORT}`));