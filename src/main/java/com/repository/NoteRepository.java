package com.repository;

import com.model.Category;
import com.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Iterable<Note>findAllByCategory(Category category);
}
