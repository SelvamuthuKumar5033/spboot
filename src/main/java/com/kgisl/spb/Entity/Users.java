package com.kgisl.spb.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

// public record Users(

//         @Id
//         @GeneratedValue(strategy = GenerationType.IDENTITY)
//         Integer id,
//         String username,
//         String password,
//         String role ){
// }

@Entity
@Table(name = "users")
public class Users {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String role = "user";

    public Users() {
    }

    public Users(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}