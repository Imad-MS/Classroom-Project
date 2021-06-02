package com.techb.javaBasics;

public class Student {
    private String name;
    private String last_name;
    private String phone_number;
    private String ssn;
    private String gpa;
    private String student_id;
    private String email;


    public Student(String name, String last_name, String phone_number, String ssn, String gpa, String student_id, String email) {
        this.name = name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.ssn = ssn;
        this.gpa = gpa;
        this.student_id = student_id;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getGpa() {
        return gpa;
    }
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Gets a student's information in the form of an array.
    public String[] getList(){
        String[] list = {name, last_name,phone_number, ssn, gpa, String.valueOf(student_id), email};
        return list;
    }

}
