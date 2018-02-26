package com.example.bookstoresystembackend.entity;

import com.example.bookstoresystembackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
public class BookViewsAndDate {

    @JsonView(Views.Public.class)
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
    @Column(name = "VIEWS")
    private int views;

//    @JsonView(Views.Public.class)
//    @NotNull
//    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "EET")
//    @Column(name = "DATE")
//    @Temporal(TemporalType.DATE)
//    private Calendar date;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "MONTH")
    private int month;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "USERNAME")
    private String username;

    public BookViewsAndDate(Long idBook, int views, int month, String username) {
        this.idBook = idBook;
        this.views = views;
        this.month = month;
        this.username = username;
    }

    public BookViewsAndDate() {
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
