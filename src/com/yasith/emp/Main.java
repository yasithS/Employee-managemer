package com.yasith.emp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        System.out.println("Welcome to employee manager");
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show all Employees\n" +
                    "3. Search Employee(by Id)\n" +
                    "4. Update Employee(by Id)\n" +
                    "5. Delete Employee(by Id)\n" +
                    "6. Exit ");

            System.out.println("Enter your choice: ");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Adding Employee to the system");
                    System.out.println("Enter Id: ");
                    int id = scan.nextInt();
                    System.out.println("Enter Name: ");
                    String name = scan.next();
                    System.out.println("Enter Salary: ");
                    double salary = scan.nextDouble();
                    System.out.println("Enter age");
                    int age = scan.nextInt();

                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    employeeDao.createEmployee(emp);
                    break;
                case 2:
                    System.out.println("Showing all Employees");
                    employeeDao.showAllEmployee();
                    break;
                case 6:
                    System.out.println("Thank you....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }while(true);
    }
}