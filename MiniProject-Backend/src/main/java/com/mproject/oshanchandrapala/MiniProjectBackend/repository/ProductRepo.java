package com.mproject.oshanchandrapala.MiniProjectBackend.repository;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,String> {
    Optional<Product> findByProductName(String productName);
    List<Product> findAllByCategoryId(String categoryId);
}
