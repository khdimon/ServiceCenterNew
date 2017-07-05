package com.softserve.edu.service_center_new.dto;

import com.softserve.edu.service_center_new.entity.User;

public class UserDTO {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String password;
    private String role;
    private String mail;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.password = user.getPassword();
        this.role = user.getRole().getName();
        this.mail = user.getMail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
