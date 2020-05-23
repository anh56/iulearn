package com.iu.iulearn.controller;


import com.iu.iulearn.model.Category;
import com.iu.iulearn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public Object getAllCategory() {
        try {
            List<Category> categoryList = categoryService.getAllCategory();
            return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public Object add(@RequestBody Category category) {
        try {
            categoryService.addCategory(category);
            return new ResponseEntity<String>("Added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable int id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

