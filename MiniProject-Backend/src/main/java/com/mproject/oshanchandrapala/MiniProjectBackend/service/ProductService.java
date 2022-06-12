package com.mproject.oshanchandrapala.MiniProjectBackend.service;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Product;
import com.mproject.oshanchandrapala.MiniProjectBackend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        product.setProductId(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getAllByCid(String categoryId){
        return productRepo.findAllByCategoryId(categoryId);
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProduct(String productId){
        productRepo.deleteById(productId);
    }

    public Optional<Product> findProductByPName(String productName){
        return productRepo.findByProductName(productName);
    }

    public Optional<Product> findProductById(String productId){
        return productRepo.findById(productId);
    }
}
