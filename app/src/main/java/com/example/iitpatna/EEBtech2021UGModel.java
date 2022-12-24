package com.example.iitpatna;

public class EEBtech2021UGModel {
    int image;
    String Name, Roll, Email;



    Boolean isExpandable;





    public EEBtech2021UGModel(int image, String name, String roll, String email) {
        this.image = image;
        this.Name = name;
        this.Roll = roll;
        this.Email = email;

        this.isExpandable = false;
    }
    public EEBtech2021UGModel( String name, String roll, String email) {
        this.Name = name;
        this.Roll = roll;
        this.Email = email;
        this.isExpandable = false;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public Boolean getExpandable() {
        return isExpandable;
    }

    public void setExpandable(Boolean expandable) {
        isExpandable = expandable;
    }


    @Override
    public String toString() {
        return "EEBtech2021UGModel{" +
                "image=" + image +
                ", Name='" + Name + '\'' +
                ", Roll='" + Roll + '\'' +
                ", Email='" + Email + '\'' +
                ", isExpandable=" + isExpandable +
                '}';
    }
}
