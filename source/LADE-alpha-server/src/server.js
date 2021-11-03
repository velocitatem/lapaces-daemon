import express from 'express';
import bodyParser from 'body-parser';

const app = express();

app.use(bodyParser.json())


app.get("/modules", (req, res) => {
  res.json(["Astronomy", "Psychology", "Economy", "Politics", "Mathematic", "Physics"])
})

app.get("/data", (req, res) => {

})

app.listen(8080, () => console.log("Started and listening on :8080"))
