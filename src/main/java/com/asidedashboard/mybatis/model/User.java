package com.asidedashboard.mybatis.model;


import java.util.Date;

public class User {

    private int id;
    private String username;
    private String email;
    private String gender;
    private String phoneNumber;
    private boolean status;
    private String userHash;
    private Date createdDate;

    public User() {
    }

    public User(int id, String username, String email, String gender, String phoneNumber, boolean status, String userHash, Date createdDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.userHash = userHash;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
