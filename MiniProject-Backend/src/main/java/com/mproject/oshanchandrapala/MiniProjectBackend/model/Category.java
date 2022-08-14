package com.mproject.oshanchandrapala.MiniProjectBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @Column(length=50, nullable = false,updatable = false)
    private String categoryId;
    @Column(nullable = false)
    private String categoryName;
    @Column(nullable = false)
    private String categoryDesc;
    @Column(nullable = false)
    private String img;

    public Category() {
    }

    public Category(String categoryId, String categoryName, String categoryDesc, String img) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
