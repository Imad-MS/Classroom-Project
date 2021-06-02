package com.techb.javaBasics;

import java.util.ArrayList;

public class StudentsDAO {
    private ArrayList<Student> student_list = new ArrayList<Student>();

    //adds a student to the list
    public void addStudent(String name, String last_name, String phone_number, String ssn, String gpa, String student_id, String email){
        //checks to see if the student's ID already exists
        boolean already_exists = false;
        for(int i = 0; i < student_list.size(); i++){
            if (student_list.get(i).getStudent_id() == student_id){
                already_exists = true;
            }
        }

        //if the ID doesn't exist, add the student
        if (already_exists == false){
            student_list.add(new Student(name, last_name, phone_number, ssn, gpa,student_id, email));
            System.out.println("Student added.");
        //if the ID does already exist, return an error
        } else {
            System.out.println("Adding student '" + name + " " + last_name + "' failed. Student ID '" + student_id + "'  exists. ");
        }

    }

    //removes a student from the list.
    public void removeStudent(String student_id){
        boolean exists = false;
        for(int i = 0; i < student_list.size(); i++){
            //if the student ID exists, then remove the student's information
            if (student_list.get(i).getStudent_id().equals(student_id)){
                exists = true;
                student_list.remove(i);
                System.out.println("Student removed.");
                break;
            }
        }
        //if the student does not exist, then return an error
        if(!exists){
            System.out.println("Remove Student Error: Student with the ID '" + student_id + "' does not exist.");
        }
    }

    //update the student's information
    public void updateStudentInfo(String student_id, String name, String last_name, String phone_number, String ssn, String gpa, String email){
        boolean exists = false;
        int index = 0;
        //checks to see if the student's ID exists in the list
        for(int i = 0; i < student_list.size(); i++){
            if (student_list.get(i).getStudent_id().equals(student_id)){
                exists = true;
                index = i;
            }
        }
        //if the student's ID doesn't exist, return an error.
        if (exists == false){
            System.out.println("Update Student Error: Student with the ID '" + student_id + "' does not exist.");
        //if the student's ID does exist, then update the information based on the parameters of this method.
        } else {
            student_list.get(index).setName(name);
            student_list.get(index).setLast_name(last_name);
            student_list.get(index).setPhone_number(phone_number);
            student_list.get(index).setSsn(ssn);
            student_list.get(index).setGpa(gpa);
            student_list.get(index).setEmail(email);
            System.out.println("Successfully updated information for '" + name + " " + last_name + "'.");
        }
    }

    //print out the table in a table-style format
    public void listAllStudents(){
        //spacing formatting
        String format = "%20s %20s %20s %15s %10s %15s %25s\n";

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(format, "FIRST NAME", "LAST NAME", "PHONE NUMBER", "SSN", "GPA", "STUDENT ID", "EMAIL");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < student_list.size(); i++){
            String[] row = student_list.get(i).getList();
            System.out.format(format, row);
        }
    }

    //makes sure that the number of students does not exceed 10
    public boolean canAdd(){
        if(student_list.size() >= 10){
            return false;
        } else {
            return true;
        }
    }

}
