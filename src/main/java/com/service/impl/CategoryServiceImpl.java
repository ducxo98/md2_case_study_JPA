package com.service.impl;

import com.model.Category;
import com.model.Note;
import com.repository.CategoryRepository;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);

    }

}
