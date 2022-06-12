package com.mproject.oshanchandrapala.MiniProjectBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Product implements Serializable {

    @Id
    @Column(length=50, nullable = false, updatable = false)
    private String productId;
    @Column(nullable = false,updatable = false)
    private String categoryId;
    @Column(nullable = false)
    private String productName;
    private String productDesc;

    public Product() {
    }

    public Product(String productId, String categoryId, String productName, String productDesc) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
