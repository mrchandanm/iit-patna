package com.example.iitpatna;

public class Profile {
    String name, branch, department, roll, iitpmail;
    public Profile(String name, String branch, String department, String roll, String iitpmail) {
        this.name = name;
        this.branch = branch;
        this.department = department;
        this.roll = roll;
        this.iitpmail = iitpmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getIitpmail() {
        return iitpmail;
    }

    public void setIitpmail(String iitpmail) {
        this.iitpmail = iitpmail;
    }
}
