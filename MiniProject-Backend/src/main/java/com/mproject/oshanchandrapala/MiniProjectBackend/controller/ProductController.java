package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.Utility.ProductUtility;
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
@RequestMapping("v1/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable ("categoryId") String categoryId){
        ProductUtility productUtility = new ProductUtility();
        return new ResponseEntity<>(productUtility.GetProducts(categoryId,productService),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product crProduct = null;
        try{
            crProduct = productService.addProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(crProduct,HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable ("productId") String productId,@RequestBody Product product ){
        ProductUtility productUtility = new ProductUtility();
        return new ResponseEntity<>(productUtility.updatingProduct(productId,product,productService), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){
        try{
            productService.deleteProduct(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Product> findProduct(@PathVariable ("productName") String productName){
        ProductUtility productUtility = new ProductUtility();
        return new ResponseEntity<>(productUtility.findingProductByName(productName,productService),HttpStatus.FOUND);
    }
}
