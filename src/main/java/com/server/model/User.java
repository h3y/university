package com.server.model;

import javax.persistence.*;

/**
 * Created by Slavik Glodan on 08.12.2016.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "login", nullable = false, length = 64, unique = true)
    private String login;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "role", nullable = false, length = 64)
    private int role;
    @Column(name = "first_name", nullable = false, length = 64)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 64)
    private String last_name;
    @Column(name = "third_name", nullable = false, length = 64)
    private String third_name;
    @Column(name = "email", length = 64)
    private String email;
    @Column(name = "photo",columnDefinition = "longtext")
    private String photo;
    @Column(name = "confirm", nullable = false, columnDefinition = "tinyint(1) default '0'")
    private boolean confirm;
    @Column(name = "active", nullable = false, columnDefinition = "tinyint(1) default '1'")
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
