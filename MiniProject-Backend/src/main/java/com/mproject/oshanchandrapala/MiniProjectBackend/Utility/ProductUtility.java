package com.mproject.oshanchandrapala.MiniProjectBackend.Utility;

import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Product;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.ProductService;

import java.util.List;

public class ProductUtility {

    public List<Product> GetProducts(String categoryId, ProductService productService){
        List<Product> productsByCategoryId = null;

        try{
            productsByCategoryId = productService.getAllByCid(categoryId);

        }catch (Exception e){
            e.printStackTrace();
        }
        return productsByCategoryId;
    }

    public Product updatingProduct(String productId,Product product, ProductService productService){
        Product upProduct = null;
        try{
            upProduct = productService.findProductById(productId).orElseThrow(()-> new ResourceNotFoundException("Product {"+productId +"} does not exist"));
            upProduct.setProductName(product.getProductName());
            upProduct.setProductDesc(product.getProductDesc());

            productService.updateProduct(upProduct);

        }catch (Exception e){
            e.printStackTrace();
        }
        return upProduct;
    }

    public Product findingProductByName(String productName, ProductService productService){
        Product findProduct = null;
        try{
            findProduct = productService.findProductByPName(productName).orElseThrow(()-> new ResourceNotFoundException("Product {"+productName+"} does not exist"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return findProduct;
    }
}
