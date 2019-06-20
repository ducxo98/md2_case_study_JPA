package com.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public Note(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString(){
        return String.format("Note[id=%d,title='%s',content='%s'",id,title,content);
    }
    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
