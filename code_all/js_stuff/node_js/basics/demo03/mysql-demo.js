const mysql = require('mysql2');
const conn = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "ora123"
});

conn.connect(err => {
  if (err) throw err;
  console.log('connected');
});

// Read All Records
// -------------------

// conn.query("SELECT * FROM emp_table", (err, result) => {
//   if (err) throw err;
//   result.forEach(row => console.log(JSON.stringify(row)));
//   conn.end();
// });

// Search Records
// -------------

// const selectQuery = "SELECT * FROM emp_table WHERE name LIKE '%raj%'";
// conn.query(selectQuery, (err, result) => {
//   if (err) throw err;
//   result.forEach(row => console.log(JSON.stringify(row)));
//   conn.end();
// });



// Insert Record
// ----------------
// const insertQuery = "INSERT INTO emp_table(id, age, name) VALUES('122', 22, 'amit')";
// conn.query(insertQuery, (err, result) => {
//   if (err) throw err;
//   console.log('inserted');
//   conn.end();
// });
