package com.example.iitpatna;

import android.net.Uri;

public class AddStudentModel {
    String name, roll, mail,image;


    public AddStudentModel(String name, String roll, String mail, String image) {
        this.name = name;
        this.roll = roll;
        this.mail = mail;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
}
