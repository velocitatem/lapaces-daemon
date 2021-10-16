var exec = require('child_process').exec,
    child;
var it = 0;
var vec = [
  ["./cnn-crawler.js", 250]
]
function command() {
  setTimeout( () => {
    for(var v in vec) {
        v = vec[v]
      if((it%v[1]) == 0){
        child = exec('node '+v[0],
        async function (error, stdout, stderr) {
          console.log(v+' output:\t' + stdout);
          if (error !== null) {
            console.log('exec error: ' + error);
          }
        });
      }
      else {
        console.log("skipping " + v[0] + " @ " + it)
      }
    }
    it+=1;
    command();
  }, 60000);
}

command()
