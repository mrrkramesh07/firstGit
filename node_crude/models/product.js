

const db = require('../util/database')


module.exports = class Product {
    constructor(id,name){
      this.id = id;
      this.name = name;
    }
      
  static fetchAll() {
 return  db.execute('SELECT * FROM products');
}
  //   return db.execute('SELECT * FROM products').then(rows=>{
  //     console.log(rows)
  // }).catch(err=>{
  //     console.log(err)
  // })

  save(){
    console.log("save")
    console.log(this.name)
    return db.execute('INSERT INTO products(name) VALUES (?)',
    [this.name]);
  }

static findById(id){
  return db.execute('SELECT * FROM products WHERE products.id =?', [id]);
}

  update(id){
    console.log("id")
    console.log(this.id)
    console.log(this.name)
  // return db.execute('UPDATE products SET name=? WHERE id=?',[this.name][this.id] );

  // return db.execute('UPDATE products SET name='+this.name+'WHERE id='+this.id);
  return db.execute('UPDATE products SET name='+"'"+this.name+"'"+ 'WHERE id='+[this.id]);

}











static deleteById(id) {
  return db.execute('delete from products where products.Id=?' ,[id]);
}

};




    
