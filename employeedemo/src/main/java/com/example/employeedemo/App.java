package com.example.employeedemo;

/**
 * Hello world!
 *
 */

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO edao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:

                    Employee emp = new Employee();

                    System.out.print("Enter Employee ID: ");
                    emp.setEmployeeId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    emp.setEmployeeName(sc.nextLine());

                    System.out.print("Enter Department: ");
                    emp.setDepartment(sc.nextLine());

                    System.out.print("Enter Salary: ");
                    emp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Joining Date (yyyy-mm-dd): ");
                    emp.setJoiningDate(LocalDate.parse(sc.nextLine()));

                    edao.save(emp);

                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:

                    System.out.println("\n===== EMPLOYEE LIST =====");

                    for (Employee e : edao.findAll()) {

                        System.out.println(
                                e.getEmployeeId() + " | " +
                                e.getEmployeeName() + " | " +
                                e.getDepartment() + " | " +
                                e.getSalary() + " | " +
                                e.getJoiningDate());
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    Employee found = edao.findById(id);

                    if (found != null) {

                        System.out.println("\nEmployee Details");
                        System.out.println("ID        : " + found.getEmployeeId());
                        System.out.println("Name      : " + found.getEmployeeName());
                        System.out.println("Department: " + found.getDepartment());
                        System.out.println("Salary    : " + found.getSalary());
                        System.out.println("Join Date : " + found.getJoiningDate());

                    } else {

                        System.out.println("Employee Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID To Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Employee updateEmp = new Employee();
                    updateEmp.setEmployeeId(uid);

                    System.out.print("Enter New Employee Name: ");
                    updateEmp.setEmployeeName(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    updateEmp.setDepartment(sc.nextLine());

                    System.out.print("Enter New Salary: ");
                    updateEmp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter New Joining Date (yyyy-mm-dd): ");
                    updateEmp.setJoiningDate(LocalDate.parse(sc.nextLine()));

                    edao.update(updateEmp);

                    System.out.println("Employee Updated Successfully!");
                    break;

                case 5:

                    System.out.print("Enter Employee ID To Delete: ");
                    int did = sc.nextInt();

                    edao.delete(did);

                    System.out.println("Employee Deleted Successfully!");
                    break;

                case 6:

                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}
