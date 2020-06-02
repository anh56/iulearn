package com.iu.iulearn.controller;


import com.iu.iulearn.model.Category;
import com.iu.iulearn.service.CategoryService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/category")
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

    @PostMapping("/add")
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

//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String deleteCategory(@RequestParam("id") Integer catedoryId, Model model){
//        categoryService.deleteCategory(catedoryId);
//        return "redirect:/";
//    }

    @PutMapping("/{id}")
    public Object updateCategoryById(@PathVariable int id, @RequestBody Category category){
        try {
            category.setId(id);
            categoryService.updateCategory(category);
            return new ResponseEntity<>("Updated category with id: "+id, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Update category by id: "+id+ "failed with exception: "+ e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteCategoryById(@PathVariable int id){
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>("Deleted category by id: "+id, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Delete category by id:"+id+" failed with exception: "+e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }
}

