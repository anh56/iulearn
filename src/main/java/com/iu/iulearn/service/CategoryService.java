package com.iu.iulearn.service;

import com.iu.iulearn.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    void updateCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategory();
    void deleteCategory(int id);

}
