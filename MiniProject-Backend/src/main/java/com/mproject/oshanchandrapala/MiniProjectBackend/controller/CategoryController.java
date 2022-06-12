package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product-categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = null;

        try{
            categories  = categoryService.getAllCategories();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category newCategory = null;
        try{
            newCategory = categoryService.addCategory(category);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable ("categoryId") String categoryId, @RequestBody Category category){
        Category categoryUpdate = null;

        try{
            categoryUpdate = categoryService.findCategoryById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category {"+categoryId +"} does not exist"));
            categoryUpdate.setCategoryName(category.getCategoryName());
            categoryUpdate.setCategoryDesc(category.getCategoryDesc());

            categoryService.updateCategory(categoryUpdate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(categoryUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId){
        try{
            categoryService.deleteCategory(categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{categoryId}")
    public ResponseEntity<Category> findCategory(@PathVariable ("categoryId") String categoryId){
        Category findCategory = null;
        try{
            findCategory = categoryService.findCategoryById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category {"+categoryId+"} not exist"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(findCategory,HttpStatus.FOUND);
    }
}
