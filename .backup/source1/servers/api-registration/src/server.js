const axios = require("axios");
const cheerio = require("cheerio");
const pretty = require("pretty");
const data = require("../creds.json")
console.log(data);

async function scrape(path) {
  var url = path;
  try {
    const { data } = await axios.get(url);
    const $ = cheerio.load(data);
    console.log($("#member-registration").text())
  } catch (err) {
    console.error(err);
  }
}


scrape("https://opensky-network.org/index.php?option=com_users&view=registration")
