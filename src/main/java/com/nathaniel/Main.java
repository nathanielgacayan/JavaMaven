package com.nathaniel;
import java.util.*;
import java.io.*;
import com.nathaniel.model.Student;

public class Main {
    public static void main(String[] args) {
       Student s = new Student();
       s.greet();
        try {
       Scanner scanner = new Scanner(new File("data/students.csv"));
       while(scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
       }
       scanner.close();
    }catch(FileNotFoundException e) {
        e.printStackTrace();
    }
}
}