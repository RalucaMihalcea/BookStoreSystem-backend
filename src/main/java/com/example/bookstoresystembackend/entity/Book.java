package com.example.bookstoresystembackend.entity;

import com.example.bookstoresystembackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @JsonView(Views.Public.class)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    @Column(name = "PRICE")
    private double price;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "NAMEPICTURE")
    private String namePicture;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "STARS")
    private int stars;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "NOTIFIED")
    private int notified;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "PDFLINK")
    private String pdfLink;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "AUDIOLINK")
    private String audioLink;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "IMAGELINK")
    private String imageLink;

    public Book() {

    }

    public Book(String title, String author, double price, int stars) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stars = stars;
    }

    public Book(String title, String author, String category, double price, String namePicture, int stars, String description, String pdfLink, String audioLink, String imageLink) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.namePicture = namePicture;
        this.stars = stars;
        this.description = description;
        this.pdfLink = pdfLink;
        this.audioLink = audioLink;
        this.imageLink = imageLink;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNotified() {
        return notified;
    }

    public void setNotified(int notified) {
        this.notified = notified;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
