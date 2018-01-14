package com.example.bookstoresystembackend.entity;

import com.example.bookstoresystembackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FavoriteBook {

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "IDBOOK")
    private Long idBook;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "TITLE")
    private String title;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "AUTHOR")
    private String author;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "CATEGORY")
    private String category;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "NAMEPICTURE")
    private String namePicture;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "USERNAME")
    private String username;

    public FavoriteBook() {
    }

    public FavoriteBook(Long idBook, String title, String author, String category, String namePicture, String username) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.category = category;
        this.namePicture = namePicture;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
