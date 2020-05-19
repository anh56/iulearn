package com.iu.iulearn.service;

import com.iu.iulearn.model.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void update(Category category);
    Category getById(int id);
    List<Category> getAllCategory();
    void delete(int id);

}
