package com.example.bookstoresystembackend.entity;

import com.example.bookstoresystembackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_USER")
public class User {

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column(name = "CONTACT_NO")
    private String contactNo;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column(name = "ADDRESS")
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
