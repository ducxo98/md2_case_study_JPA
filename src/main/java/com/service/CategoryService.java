package com.service;

import com.model.Category;
import com.model.Note;

public interface CategoryService {
    Iterable<Category>findAll();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
