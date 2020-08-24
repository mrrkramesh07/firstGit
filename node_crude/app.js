const path=require('path');
const http=require('http');
const express=require('express');
const bodyParser=require('body-parser')
const app=express() 

const db=require('./util/database');


app.set('view engine','ejs');
app.set('views','views');

const adminRoute=require('./routes/admin');


// return db.execute('SELECT * FROM products').then(result=>{
//     console.log(result)
// }).catch(err=>{
//     console.log(err)
// })



app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname,'public')));


app.use('/admin',adminRoute);


const server=http.createServer(app);
server.listen(3000);