package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Product;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all/{categoryId}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable ("categoryId") String categoryId){

        List<Product> productsByCategoryId = null;

        try{
            productsByCategoryId = productService.getAllByCid(categoryId);
            
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(productsByCategoryId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product crProduct = null;

        try{
            crProduct = productService.addProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(crProduct,HttpStatus.CREATED);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable ("productId") String productId,@RequestBody Product product ){
        Product upProduct = null;
        try{
            upProduct = productService.findProductById(productId).orElseThrow(()-> new ResourceNotFoundException("Product {"+productId +"} does not exist"));
            upProduct.setProductName(product.getProductName());
            upProduct.setProductDesc(product.getProductDesc());

            productService.updateProduct(upProduct);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(upProduct, HttpStatus.OK);
    }

    @DeleteMapping("delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){
        try{
            productService.deleteProduct(productId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("find/{productName}")
    public ResponseEntity<Product> findProduct(@PathVariable ("productName") String productName){
        Product findProduct = null;
        try{
            findProduct = productService.findProductByPName(productName).orElseThrow(()-> new ResourceNotFoundException("Product {"+productName+"} does not exist"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(findProduct,HttpStatus.FOUND);
    }
}
