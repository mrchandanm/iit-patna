package com.example.iitpatna;

public class FacultyDirectoryModel {
    String Name, Designation, PhoneExtension, EmailId, Post;

    public FacultyDirectoryModel(String Name, String Designation, String PhoneExtension, String EmailId){
        this.Name= Name;
        this.Designation = Designation;
        this.PhoneExtension = PhoneExtension;
        this.EmailId = EmailId;
    }

    public FacultyDirectoryModel(String Name, String Designation, String PhoneExtension, String EmailId,String Post){
        this.Name= Name;
        this.Designation = Designation;
        this.PhoneExtension = PhoneExtension;
        this.EmailId = EmailId;
        this.Post = Post;
    }
}


