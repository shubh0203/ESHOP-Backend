package com.Eshop.shop.entitie;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Eshop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstname;

    @Column(name="last_name",length = 20)
    private String lastName;

    @Column(length = 20)
    private String email;

    @Column(name="user_name",length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime created;

    private LocalDateTime updated;

     @Column(name = "phone_number", nullable = false)
    private String phoneNumbers;

    @Column( nullable = false)
    private String role;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String firstname, String lastName, String email, String username, String password, LocalDateTime created, LocalDateTime updated, String phoneNumbers, String role) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.created = created;
        this.updated = updated;
        this.phoneNumbers = phoneNumbers;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
