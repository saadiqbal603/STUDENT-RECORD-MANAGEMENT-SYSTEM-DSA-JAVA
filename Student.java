
package com.company;


public class Student {

    Node head;

    // Check if the record exists or not before?
    boolean find(int roll) {
        Node temp = head;

        // if null return false
        if (head == null)
            return false;

            // Check the List
        else {
            while (temp != null) {
                if (temp.roll == roll)
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }

    // Function to add new Record
    void insertRecord(int roll, String name,
                      String Dept, int marks)
    {

        // Check Record Exist Before?
        if (find(roll) == true) {
            System.out.println("Student with this Roll Already Exist");
            return;
        }

        // Create temporary node
        Node temp = new Node(roll, name, Dept, marks);



        // Insertion at first
        if (head == null || head.roll >= temp.roll) {
            temp.next = head;
            head = temp;
        }

        // Insertion in Middle and Insertion in End
        else {
            Node newNode= head;
            while (newNode.next != null && newNode.next.roll < temp.roll) {
                newNode= newNode.next;
            }
            temp.next = newNode.next;
            newNode.next = temp;
        }
        System.out.println("Record has been Inserted Successfully");
    }

    // Function to search record by roll no
    void searchRecord(int roll)
    {
        if (head == null) {
            System.out.println("Please Check: No Record Available ");
            return;
        }

        // Otherwise
        else {
            Node temp = head;
            while (temp != null) {
                if (temp.roll == roll) {
                    System.out.println("Roll Number\t" + temp.roll);
                    System.out.println("Name\t\t" + temp.name);
                    System.out.println("Department\t" + temp.Dept);
                    System.out.println("Marks\t\t" + temp.marks);
                    return;
                }
                temp = temp.next;
            }
            if (temp == null)
                System.out.println("No Record have been found  Or Roll No is Incorrect ");
        }
    }

    //Function to delete roll number by comparing the roll if exist before or not
    public int deleteRecord(int roll)
    {
        Node temp = head;
        Node previous= null;

        // Delete First
        if (temp != null && temp.roll == roll) {
            head = temp.next;
            System.out.println("Record has been Deleted Successfully");
            return 0;
        }

        // Deletion at Middle or End
        while (temp != null && temp.roll != roll) {
            previous = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Record is not Available");
            return -1;
        }
        previous.next = temp.next;
        System.out.println("Record has been Deleted Successfully");
        return 0;
    }

    //To view all record
    void showRecord()
    {
        Node temp = head;
        if (temp == null) {
            System.out.println("No Such Record Available");
        }
        else {
            System.out.println("RollNo  \t  Name  \t  Course  \t  Marks");
            while (temp!= null) {
                System.out.println(temp.roll + " \t\t  " + temp.name + "\t\t  " + temp.Dept + "\t\t  " + temp.marks);
                temp= temp.next;
            }
        }
    }
}
