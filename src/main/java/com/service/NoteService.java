package com.service;

import com.model.Category;
import com.model.Note;

public interface NoteService {
    Iterable<Note>findAll();
    Note findById(Long id);
    void save(Note note);
    void remove(Long id);
    Iterable<Note>findAllByCategory(Category category);
}
