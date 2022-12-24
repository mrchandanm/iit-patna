package com.example.iitpatna;

public class StudentsModel {
    String name;
    String roll;
    String mail;
    String image;
//    Boolean isExpandable;

    public StudentsModel(String name, String roll, String mail, String image) {
        this.name = name;
        this.roll = roll;
        this.mail = mail;
        this.image = image;
//        this.isExpandable = false;
    }

    public StudentsModel() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Boolean getExpandable() {
//        return isExpandable;
//    }
//
//    public void setExpandable(Boolean expandable) {
//        isExpandable = expandable;
//    }

    @Override
    public String toString() {
        return "StudentsModel{" +
                "name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", mail='" + mail + '\'' +
                ", image='" + image + '\'' +
//                ", isExpandable=" + isExpandable +
                '}';
    }
}
