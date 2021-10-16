var StopwordsFilter = require('node-stopwords-filter');
let Parser = require('rss-parser');
var websiteUrl = "http://rss.cnn.com/rss/edition.rss";
let parser = new Parser();
var f = new StopwordsFilter();
let keywords = [];
(async () => {
    let feed = await parser.parseURL(websiteUrl);
    feed.items.forEach(item => {
      let tit = item.title
      let parsed = f.filter(tit);
      parsed.forEach((r) => {
        if(!keywords.includes(r)) {
          keywords.push(r);
        }
      })
    });
})().then(() => {
  console.log("Crawled data")
  require('fs').writeFile(
    './data/cnn-topics-raw-data',
    JSON.stringify(keywords),
    function (err) {
        if (err) {
            console.error('Crap happens');
        }
    }
  );
})
