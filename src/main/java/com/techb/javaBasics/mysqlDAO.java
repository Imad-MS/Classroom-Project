package com.techb.javaBasics;

import java.sql.*;

public class mysqlDAO {
    private int num_entries; //counts the number of entries in the list

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://studentdatabase.cfv3b5is6sow.us-east-2.rds.amazonaws.com:3306/studentDATA";
    final String USER = "admin";
    final String PASS = "admin123";

    Connection conn = null;

    public mysqlDAO(){
        num_entries = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating table in given database...");
            Statement stmt = conn.createStatement();
            //String sql = "INSERT INTO `testTable` (`AccountID`,`firstName`,`lastName`,`age`) VALUES ( 4,'Jay','C',21);";

            String sql = "CREATE TABLE testTable (" +
                    " name VARCHAR(255), " +
                    " last_name VARCHAR(255), " +
                    " phone_number VARCHAR(255), " +
                    " ssn VARCHAR(255), " +
                    " gpa VARCHAR(255), " +
                    " student_id VARCHAR(255), " +
                    " email VARCHAR(255));";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String last_name, String phone_number, String ssn, String gpa, String student_id, String email){
        try {
            Statement stmt = conn.createStatement();
            StringBuilder sql_temp = new StringBuilder();
            sql_temp.append("INSERT INTO testTable VALUES ('");
            sql_temp.append(name);
            sql_temp.append("', '");
            sql_temp.append(last_name);
            sql_temp.append("', '");
            sql_temp.append(phone_number);
            sql_temp.append("', '");
            sql_temp.append(ssn);
            sql_temp.append("', '");
            sql_temp.append(gpa);
            sql_temp.append("', '");
            sql_temp.append(student_id);
            sql_temp.append("', '");
            sql_temp.append(email);
            sql_temp.append("');");
            String sql = sql_temp.toString();

            stmt.executeUpdate(sql);
            System.out.println("Created entry in database.");
            num_entries++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeStudent(String student_id){
        try {
            Statement stmt = conn.createStatement();
            StringBuilder sql_temp = new StringBuilder();
            sql_temp.append("DELETE FROM testTable WHERE student_id = '");
            sql_temp.append(student_id);
            sql_temp.append("';");

            String sql = sql_temp.toString();

            stmt.executeUpdate(sql);
            System.out.println("Deleted entry in database.");
            num_entries--;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateStudentInfo(String student_id, String name, String last_name, String phone_number, String ssn, String gpa, String email){
        try {
            Statement stmt = conn.createStatement();
            StringBuilder sql_temp = new StringBuilder();
            sql_temp.append("UPDATE testTable SET name = '");
            sql_temp.append(name);
            sql_temp.append("', last_name = '");
            sql_temp.append(last_name);
            sql_temp.append("', phone_number = '");
            sql_temp.append(phone_number);
            sql_temp.append("', ssn = '");
            sql_temp.append(ssn);
            sql_temp.append("', gpa = '");
            sql_temp.append(gpa);
            sql_temp.append("', email = '");
            sql_temp.append(email);
            sql_temp.append("' WHERE student_id = '");
            sql_temp.append(student_id);
            sql_temp.append("';");

            String sql = sql_temp.toString();

            stmt.executeUpdate(sql);
            System.out.println("Updated entry in database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAllStudents(){
        try {
            Statement stmt = conn.createStatement();
            StringBuilder sql_temp = new StringBuilder();
            ResultSet rs = stmt.executeQuery("SELECT * FROM testTable;");

            String format = "%20s %20s %20s %15s %10s %15s %25s\n";

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(format, "FIRST NAME", "LAST NAME", "PHONE NUMBER", "SSN", "GPA", "STUDENT ID", "EMAIL");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

            while(rs.next()){
                String[] row = {rs.getString("name"), rs.getString("last_name"),
                        rs.getString("phone_number"), rs.getString("ssn"),
                        rs.getString("gpa"), rs.getString("student_id"), rs.getString("email")};
                System.out.format(format, row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean canAdd(){
        if (num_entries >= 10){
            return false;
        } else {
            return true;
        }
    }

}
