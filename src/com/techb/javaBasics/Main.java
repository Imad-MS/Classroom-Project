package com.techb.javaBasics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ui user_interface = new ui();
        user_interface.listAllStudents();

        //Status variable to exit program loop
        boolean status = true;


        //Loop that allows the user to do multiple actions in the program's runtime.
        while(status){
            System.out.println("============================");
            System.out.println("What would you like to do?");
            System.out.println(" 1. Add a new student\n 2. Remove a student\n 3. Update student information\n 4. List all students in class\n 5. Quit");
            System.out.println("============================");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            //Add a new student
            if(choice.equals("1")){
                if(user_interface.canAdd() == true){
                    System.out.println("Enter student's first name.");
                    String input_name = input.nextLine();

                    System.out.println("Enter student's last name.");
                    String input_last_name = input.nextLine();

                    System.out.println("Enter student's phone number.");
                    String input_phone_number = input.nextLine();

                    System.out.println("Enter student's SSN.");
                    String input_ssn = input.nextLine();

                    System.out.println("Enter student's GPA.");
                    String input_gpa = input.nextLine();


                    System.out.println("Enter student's ID.");
                    String input_student_id = input.nextLine();

                    System.out.println("Enter student's email address.");
                    String input_email = input.nextLine();

                    user_interface.addStudent(input_name, input_last_name, input_phone_number, input_ssn, input_gpa, input_student_id, input_email);
                } else {
                    System.out.println("Sorry, you can't add more than ten students to the class.");
                }
            // Remove a student
            } else if(choice.equals("2")){
                System.out.println("Enter the corresponding Student ID of the student you want deleted.");
                String input_student_id = input.nextLine();
                user_interface.removeStudent(input_student_id);
            // Update student information
            } else if(choice.equals("3")){
                System.out.println("Enter the corresponding Student ID of the student data you want to update.");
                String input_student_id = input.nextLine();

                System.out.println("Enter student's new first name.");
                String input_name = input.nextLine();

                System.out.println("Enter student's new last name.");
                String input_last_name = input.nextLine();

                System.out.println("Enter student's new phone number.");
                String input_phone_number = input.nextLine();

                System.out.println("Enter student's new SSN.");
                String input_ssn = input.nextLine();

                System.out.println("Enter student's new GPA.");
                String input_gpa = input.nextLine();

                System.out.println("Enter student's new email address.");
                String input_email = input.nextLine();

                user_interface.updateStudentInfo(input_student_id, input_name, input_last_name, input_phone_number, input_ssn, input_gpa, input_email);
            // List all students in class
            } else if(choice.equals("4")){
                user_interface.listAllStudents();
            // Quit
            } else if(choice.equals("5")){
                status = false;
                System.out.println("Quitting program...");
            // Invalid input
            } else {
                System.out.println("Invalid input. To choose an action, enter a number between 1 and 5.");
            }

        }
    }
}
