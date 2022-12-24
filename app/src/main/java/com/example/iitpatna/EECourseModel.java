package com.example.iitpatna;

public class EECourseModel {
    String Semester,branch;
    String EECourseName1, EECourseName2, EECourseName3,EECourseName4,EECourseName5;
    String EECourse1,EECourse2,EECourse3,EECourse4,EECourse5;
    String Reference1;
    String Reference2;
    String Reference3;
    String Reference4;
    String Reference5;

    Boolean Expandable;

    public EECourseModel(String Semester,String branch, String EECourseName1, String EECourseName2, String EECourseName3, String EECourseName4, String EECourseName5, String EECourse1, String EECourse2, String EECourse3, String EECourse4, String EECourse5, String reference1, String reference2, String reference3, String reference4, String reference5) {
        this.Semester = Semester;
        this.branch = branch;
        this.EECourseName1 = EECourseName1;
        this.EECourseName2 = EECourseName2;
        this.EECourseName3 = EECourseName3;
        this.EECourseName4 = EECourseName4;
        this.EECourseName5 = EECourseName5;
        this.EECourse1 = EECourse1;
        this.EECourse2 = EECourse2;
        this.EECourse3 = EECourse3;
        this.EECourse4 = EECourse4;
        this.EECourse5 = EECourse5;
        this.Reference1 = reference1;
        this.Reference2 = reference2;
        this.Reference3 = reference3;
        this.Reference4 = reference4;
        this.Reference5 = reference5;
        this.Expandable = false;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getEECourseName1() {
        return EECourseName1;
    }

    public void setEECourseName1(String EECourseName1) {
        this.EECourseName1 = EECourseName1;
    }

    public String getEECourseName2() {
        return EECourseName2;
    }

    public void setEECourseName2(String EECourseName2) {
        this.EECourseName2 = EECourseName2;
    }

    public String getEECourseName3() {
        return EECourseName3;
    }

    public void setEECourseName3(String EECourseName3) {
        this.EECourseName3 = EECourseName3;
    }

    public String getEECourseName4() {
        return EECourseName4;
    }

    public void setEECourseName4(String EECourseName4) {
        this.EECourseName4 = EECourseName4;
    }

    public String getEECourseName5() {
        return EECourseName5;
    }

    public void setEECourseName5(String EECourseName5) {
        this.EECourseName5 = EECourseName5;
    }

    public String getEECourse1() {
        return EECourse1;
    }

    public void setEECourse1(String EECourse1) {
        this.EECourse1 = EECourse1;
    }

    public String getEECourse2() {
        return EECourse2;
    }

    public void setEECourse2(String EECourse2) {
        this.EECourse2 = EECourse2;
    }

    public String getEECourse3() {
        return EECourse3;
    }

    public void setEECourse3(String EECourse3) {
        this.EECourse3 = EECourse3;
    }

    public String getEECourse4() {
        return EECourse4;
    }

    public void setEECourse4(String EECourse4) {
        this.EECourse4 = EECourse4;
    }

    public String getEECourse5() {
        return EECourse5;
    }

    public void setEECourse5(String EECourse5) {
        this.EECourse5 = EECourse5;
    }

    public String getReference1() {
        return Reference1;
    }

    public void setReference1(String reference1) {
        Reference1 = reference1;
    }

    public String getReference2() {
        return Reference2;
    }

    public void setReference2(String reference2) {
        Reference2 = reference2;
    }

    public String getReference3() {
        return Reference3;
    }

    public void setReference3(String reference3) {
        Reference3 = reference3;
    }

    public String getReference4() {
        return Reference4;
    }

    public void setReference4(String reference4) {
        Reference4 = reference4;
    }

    public String getReference5() {
        return Reference5;
    }

    public void setReference5(String reference5) {
        Reference5 = reference5;
    }

    public Boolean getExpandable() {
        return Expandable;
    }

    public void setExpandable(Boolean expandable) {
        Expandable = expandable;
    }

    @Override
    public String toString() {
        return "EECourseModel{" +
                "Semester='" + Semester + '\'' +
                ", EECourseName1='" + EECourseName1 + '\'' +
                ", EECourseName2='" + EECourseName2 + '\'' +
                ", EECourseName3='" + EECourseName3 + '\'' +
                ", EECourseName4='" + EECourseName4 + '\'' +
                ", EECourseName5='" + EECourseName5 + '\'' +
                ", EECourse1='" + EECourse1 + '\'' +
                ", EECourse2='" + EECourse2 + '\'' +
                ", EECourse3='" + EECourse3 + '\'' +
                ", EECourse4='" + EECourse4 + '\'' +
                ", EECourse5='" + EECourse5 + '\'' +
                ", Reference1='" + Reference1 + '\'' +
                ", Reference2='" + Reference2 + '\'' +
                ", Reference3='" + Reference3 + '\'' +
                ", Reference4='" + Reference4 + '\'' +
                ", Reference5='" + Reference5 + '\'' +
                ", Expandable=" + Expandable +
                '}';
    }
}
