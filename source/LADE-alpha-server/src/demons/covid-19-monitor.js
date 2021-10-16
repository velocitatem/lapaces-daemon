var axios = require("axios").default;
var mysql = require("mysql")
var creds = require("./credentials.json")
var options = {
  method: 'GET',
  url: 'https://who-covid-19-data.p.rapidapi.com/api/data',
  params: {},
  headers: {
    'x-rapidapi-host': 'who-covid-19-data.p.rapidapi.com',
    'x-rapidapi-key': 'bacd86d576msh7e4f10ea742f8b2p10a49cjsn06a2e594a624'
  }
};
var con = mysql.createConnection({
  host: "localhost",
  user: creds.uname,
  password: creds.password,
  database: "lade"
});
con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

axios.request(options).then(function (response) {
  var dat = response.data
  var sql = "insert into covid19_reports (data) values ('"+JSON.stringify(dat)+"')";
  con.query(sql, (e, r) => {
    console.log(r);
    process.exit(1)
  })
})
