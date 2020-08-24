const mysql = require('mysql2');

const pool = mysql.createPool({
host:'localhost',
 database: 'node-complete',
 user: 'root',
 password: 'Elutra123$',
 
});
module.exports = pool.promise();
