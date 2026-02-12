const fs = require('fs');
const data = 'Hello World!';

fs.writeFile('test.txt', data, function (err) {
  if (err) return console.log(err);
  console.log('Hello World > test.txt');
});
console.log('testing');