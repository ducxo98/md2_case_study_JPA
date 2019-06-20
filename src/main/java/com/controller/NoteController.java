package com.controller;

import com.model.Category;
import com.model.Note;
import com.service.CategoryService;
import com.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categorys")
    public Iterable<Category>categories(){
        return categoryService.findAll();
    }

    @GetMapping("/notes")
    public ModelAndView listNotes() {
        Iterable<Note> notes = noteService.findAll();
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
    @GetMapping("/create-note")
    public ModelAndView showNoteForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note",new Note());
        return modelAndView;
    }
    @PostMapping("/create-note")
    public ModelAndView saveNote(@ModelAttribute("note")Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note",note);
        modelAndView.addObject("msg","create success");
        return modelAndView;
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showeditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if (note != null){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note",note);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/euro.404");
            return modelAndView;
        }
    }
    @PostMapping("/update-note")
    public ModelAndView updateNote(@ModelAttribute("note")Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("note",note);
        modelAndView.addObject("msg","note updated new");
        return modelAndView;
    }
    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("note",note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-note")
    public String deleteNote(@ModelAttribute("note") Note note){
        noteService.remove(note.getId());
        return "redirect:notes";
    }
}
