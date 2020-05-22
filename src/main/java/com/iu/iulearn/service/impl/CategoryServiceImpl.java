package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Category;
import com.iu.iulearn.repository.CategoryRepository;
import com.iu.iulearn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void updateCategory(Category category) {
        Category categoryToUpdate = categoryRepository.findById(category.getId()).get();
        if (categoryToUpdate != null){
            categoryToUpdate.setTitle(category.getTitle());
//            categoryToUpdate.setCourses(category.getCourses());
//            categoryToUpdate.setOrderIndex(category.getOrderIndex());
            categoryRepository.save(category);
        }
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);

    }
}
