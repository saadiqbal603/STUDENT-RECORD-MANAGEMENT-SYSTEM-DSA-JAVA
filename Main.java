package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void dbConnection(String query, String type){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root",null);

            Statement stmt=con.createStatement();

            if(type == "insert" || type == "delete"){
                int rs=stmt.executeUpdate(query);
                System.out.println(rs);
            }
            else if(type == "search") {
                ResultSet rs = stmt.executeQuery(query);

                while(rs.next())
                    System.out.println(rs.getInt("id")+ " "+ rs.getString("Name")+ " "+ rs.getInt("rollNo")+ " "+ rs.getString("Dept")+" "+ rs.getString("Marks"));
            }


            System.out.println("Connection successful");
            con.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {




        // write your code here
        String user,pass;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username:");//User Input UserId
        user = sc.nextLine();

        System.out.print("Enter password:");//User Input Password

        pass = sc.next();
        System.out.println();
        if (user.equals("Admin") && pass.equals("admin")) {
            System.out.println("LogIn Successful");
            System.out.print("\n*************************************************************************************\n");
            Student data = new Student();
            String name, course;
            int roll, marks;
            int choice = 0;
                System.out.print("\n\t\t**************************************************");
                System.out.println("\n\t\tWelcome to SZABIST Student Record Management System");
                System.out.print("\t\t**************************************************\n");
                // Menu
                while (choice != 5) {

                    System.out.print("\n\t***********************************");
                    System.out.println("\n\tMenu :\n\t1 To Create a new Record\n\t2 To Delete a Student Record" +
                            "\n\t3 to Search a Student Record\n\t4 to View all the Students Record\n\t5 to Exit");
                    System.out.print("\t***********************************\n");
                    System.out.println("Enter your Choice:");

                    // Enter Choice
                    try {
                        choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input");
                        return;
                    }

                    if (choice == 1) {
                        System.out.println("Enter the Name of the Student :");
                        name = sc.next();
                        System.out.println("Enter Roll Number of Student :");
                        roll = sc.nextInt();
                        System.out.println("Enter Course of Student :");
                        course = sc.next();
                        System.out.println("Enter Total Marks of Student : ");
                        marks = sc.nextInt();
                        dbConnection("insert into user (`id`,`Name`,`rollNo`,`Dept`,`Marks`) values(NULL,'" + name + "','" + roll + "','" + course + "','" + marks + "')", "insert");
                        data.insertRecord(roll, name, course, marks);
                    } else if(choice == 2) {
                            System.out.println("Enter Roll Number of Student whose record you want to be deleted");
                            roll = sc.nextInt();
                            dbConnection("delete from user where rollNo=" + "'" + roll + "'   ", "delete");
                            data.deleteRecord(roll);
                    } else if (choice == 3) {
                            System.out.println("Enter the Roll Number of the Student whose record you want to look up.");
                            roll = sc.nextInt();
                            dbConnection("select * from user where rollNo=" + "'" + roll + "'", "search");
                            data.searchRecord(roll);
                    } else if (choice == 4) {
                            dbConnection("select * from user", "search");
                            data.showRecord();
                    } else if (choice == 5) {
                            System.out.println("~ThankYou For using ");
                            System.out.print("\n\t\t******************************************");
                            System.out.println("\n\t\tSZABIST Student Record Management System");
                            System.out.print("\t\t*******************************************\n");
                            exit(0);
                    }
                    else {
                            System.out.println("Invalid Choice Try Again");
                    }
                }

            } else{
                System.out.println("LogIn Failed Enter Correct UserName and Password");
                main(args);
            }

    }

}