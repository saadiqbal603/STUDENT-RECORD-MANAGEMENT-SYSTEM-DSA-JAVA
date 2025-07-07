package com.company;

public class Node {
    Node next;
    String Dept;
    String name;
    int marks;
    int roll;

    Node(int roll, String name, String Dept, int marks)
    {
        this.next = null;
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.Dept = Dept;
    }
}

