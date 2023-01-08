package com.company;

import com.company.service.StudentService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
	// write your code here
        StudentService studentService = new StudentService();
        // studentService.creatStudent(50,"zahra","sha",26);
       studentService.updateStudent(2006,"z","sha",26);
       // studentService.getStudentById(81);
        studentService.deleteStudentById(47);


        Boolean open = true;
        while (open){
            menu();
            int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("SELECT ALL");
                studentService.getAllStudents();
                break;
            case 2:
                System.out.println("CREAT");
                System.out.println("pls inter id : ");
                int id = scanner.nextInt();
                System.out.println("pls inter first name");
                String firstName = scanner.next();
                System.out.println("pls inter last name");
                String lastName = scanner.next();
                System.out.println("pls inter age : ");
                int age = scanner.nextInt();
                studentService.creatStudent(id, firstName, lastName, age);
                break;
            case 3:
                System.out.println("UPDATE");
                System.out.println("pls inter id : ");
                int ID = scanner.nextInt();
                System.out.println("pls inter first name");
                String FirstName = scanner.next();
                System.out.println("pls inter last name");
                String LastName = scanner.next();
                System.out.println("pls inter age : ");
                int Age = scanner.nextInt();
                studentService.updateStudent(ID, FirstName, LastName, Age);
                break;
            case 4:
                System.out.println("SELECT BY ID");
                System.out.println("pls inter id : ");
                int Id = scanner.nextInt();
                studentService.getStudentById(Id);
                break;
            case 5:
                System.out.println("DELETE");
                System.out.println("pls inter id : ");
                int ID1 = scanner.nextInt();
                studentService.deleteStudentById(ID1);
                break;
            case 6:

                open = false;
                break;
        }





        }






    }

    private static void menu() {
        System.out.println("pls select one item : ");
        System.out.println("1: getAllStudents");
        System.out.println("2: creatStudent");
        System.out.println("3: updateStudent");
        System.out.println("4: getStudentById");
        System.out.println("5: deleteStudentById");
        System.out.println("6: exist");
        System.out.println("************************************");
    }
}
