const Product=require('../models/product')

 ///// list
 exports.getProducts = (req, res, next) => {
       
  Product.fetchAll().then(([rows,fieldData])=>{
    res.render('admin/productss', {
      prods: rows
     
  });
})
.catch(err=>{
    console.log(err)})
  };


  /////add
  exports.addProduct=(req,res,next)=>{
res.render('admin/addproductss',{
});
  } ;  
  ///post
  exports.AddPostProduct=(req,res,next)=>{
    const name=req.body.name;
    const product=new Product(null,name);
    product.save().then(()=>{
      res.redirect('/');
    }).catch(erro=>{
      console.log('error');
    });
  };

exports.getEditProduct=(req,res,next)=>{
  const prodId=req.params.productId; 
  Product.findById(prodId).then(([product])=> {
    res.render('admin/editProductss',{
      product:product[0] 
    });
  })
  .catch(erro=>{
    console.log('error');
  });
};
exports.editPostSaveProduct=(req,res,next)=>{
  console.log("==============")
  console.log(req.body)
  const prodId=req.body.productId; 
 const updatedName = req.body.name;
  const updatedProduct = new Product(prodId,updatedName);
updatedProduct.update();
res.redirect('/admin/list');
};


///delete
exports.postDeleteProduct=(req,res,next)=>{
  const prodId=req.params.productId; 
  Product.deleteById(prodId);
  res.redirect('/admin/list');
};
