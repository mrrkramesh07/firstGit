
const path=require('path');
const express=require('express');

const Controller=require('../controllers/adminController');

const router=express.Router();



console.log('hhhh');
router.get('/list', Controller.getProducts);
router.get('/addProduct',Controller.addProduct);

///// post
router.post('/addSaveProduct',Controller.AddPostProduct);


router.get('/edit/:productId',Controller.getEditProduct);

router.post('/editSave',Controller.editPostSaveProduct);

router.get('/delete/:productId',Controller.postDeleteProduct);

module.exports=router;