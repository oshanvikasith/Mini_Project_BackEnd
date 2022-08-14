package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.Utility.CategoryUtility;
import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("v1/product-categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){

        CategoryUtility categoryUtility = new CategoryUtility();
        return new ResponseEntity<>(categoryUtility.ListOfCategories(categoryService), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category newCategory = null;
        try{
            newCategory = categoryService.addCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable ("categoryId") String categoryId, @RequestBody Category category){

        CategoryUtility categoryUtility = new CategoryUtility();
        return new ResponseEntity<>(categoryUtility.UpdatingCategories(categoryId,category,categoryService), HttpStatus.OK);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId){
        try{
            categoryService.deleteCategory(categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> findCategoryWithId(@PathVariable ("categoryId") String categoryId){

        CategoryUtility categoryUtility = new CategoryUtility();
        return new ResponseEntity<>(categoryUtility.findingCategoryUsingId(categoryId,categoryService),HttpStatus.FOUND);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<Category> findCategoryWithName(@PathVariable ("categoryName") String categoryName){
        CategoryUtility categoryUtility = new CategoryUtility();
        return new ResponseEntity<>(categoryUtility.findCategoryUsingName(categoryName,categoryService),HttpStatus.FOUND);
    }

}
