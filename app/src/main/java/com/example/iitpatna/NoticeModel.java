package com.example.iitpatna;

public class NoticeModel {
    String title, description, image, pdf, date , time;

    public NoticeModel(String title, String description, String image, String pdf, String date, String time) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.pdf = pdf;
        this.date = date;
        this.time = time;
    }

    public NoticeModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
