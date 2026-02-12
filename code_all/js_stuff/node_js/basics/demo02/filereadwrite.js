const fs = require('fs');
const srcPath = "text1.txt";
const savPath = "text2.txt";

fs.readFile(srcPath, 'utf8', function (err, data) {
  if (err) throw err;

  fs.writeFile(savPath, data, function (err) {
    if (err) throw err;
    console.log('complete');
  });
});