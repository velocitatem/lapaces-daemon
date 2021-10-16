var StopwordsFilter = require('node-stopwords-filter');
var mysql = require('mysql');
let Parser = require('rss-parser');
let parser = new Parser();
var f = new StopwordsFilter();
var con = mysql.createConnection({
  host: "localhost",
  user: "v310",
  password: "Saniroot1678",
  database: "lade"
});
con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});
var links = [
  ["http://rss.cnn.com/rss/edition_world.rss","World"],
  ["http://rss.cnn.com/rss/edition_americas.rss","Americas"],
  ["http://rss.cnn.com/rss/edition_europe.rss", "Europe"],
  ["http://rss.cnn.com/rss/money_news_international.rss", "Finance"],
  ["http://rss.cnn.com/rss/edition_space.rss", "Science"]
];
for(var link in links)  {
  let keywords = [];
  link = links[link];
  (async () => {
    var tag = link[1];
    let feed = await parser.parseURL(link[0]);
    feed.items.forEach(item => {
      let tit = item.title
      let parsed = f.filter(tit);
      parsed.forEach((r) => {
        if(!keywords.includes(r)) {
          keywords.push(r);
        }
      })
    });
    return tag
    })().then((t) => {
        console.log("Crawled data")
        var sql = "insert into cnn_keywords (array, tag) values ('"+JSON.stringify(keywords)+"', '"+t+"')"
        con.query(sql, (err, res) => {
            console.log(res)
        })
    })

}
