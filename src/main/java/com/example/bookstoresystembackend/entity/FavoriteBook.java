package com.example.bookstoresystembackend.entity;

import com.example.bookstoresystembackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FavoriteBook {

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
    @Column(name = "IDUSER")
    private Long idUser;

    public FavoriteBook() {
    }

    public FavoriteBook(Long idBook, Long idUser) {
        this.idBook = idBook;
        this.idUser = idUser;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
