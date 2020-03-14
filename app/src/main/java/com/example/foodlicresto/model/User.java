package com.example.foodlicresto.model;

public class User {
    private String Email;
    private String familly_name;
    private String name;
    private String password;



    public User() {
    }


    public User(String email, String familly_name, String name, String password) {
        Email = email;
        this.familly_name = familly_name;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setFamilly_name(String familly_name) {
        this.familly_name = familly_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getFamilly_name() {
        return familly_name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
