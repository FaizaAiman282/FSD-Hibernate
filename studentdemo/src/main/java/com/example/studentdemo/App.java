package com.example.studentdemo;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:

                    Student s = new Student();

                    System.out.print("Student ID: ");
                    s.setStudentId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Student Name: ");
                    s.setStudentName(sc.nextLine());

                    System.out.print("Email: ");
                    s.setEmail(sc.nextLine());

                    System.out.print("Course: ");
                    s.setCourse(sc.nextLine());

                    System.out.print("Age: ");
                    s.setAge(sc.nextInt());

                    sdao.save(s);

                    System.out.println("Student Added Successfully");
                    break;

                case 2:

                    System.out.println("\nAll Students");

                    for (Student st : sdao.findAll()) {

                        System.out.println(
                                st.getStudentId() + " " +
                                st.getStudentName() + " " +
                                st.getEmail() + " " +
                                st.getCourse() + " " +
                                st.getAge());
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    Student found = sdao.findById(sid);

                    if (found != null) {

                        System.out.println("ID : " +
                                found.getStudentId());

                        System.out.println("Name : " +
                                found.getStudentName());

                        System.out.println("Email : " +
                                found.getEmail());

                        System.out.println("Course : " +
                                found.getCourse());

                        System.out.println("Age : " +
                                found.getAge());
                    }
                    else {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter Student ID To Update: ");

                    int uid = sc.nextInt();
                    sc.nextLine();

                    Student updateStudent =
                            new Student();

                    updateStudent.setStudentId(uid);

                    System.out.print("New Name: ");
                    updateStudent.setStudentName(
                            sc.nextLine());

                    System.out.print("New Email: ");
                    updateStudent.setEmail(
                            sc.nextLine());

                    System.out.print("New Course: ");
                    updateStudent.setCourse(
                            sc.nextLine());

                    System.out.print("New Age: ");
                    updateStudent.setAge(
                            sc.nextInt());

                    sdao.update(updateStudent);

                    System.out.println(
                            "Student Updated Successfully");

                    break;

                case 5:

                    System.out.print(
                            "Enter Student ID To Delete: ");

                    int did = sc.nextInt();

                    sdao.delete(did);

                    System.out.println(
                            "Student Deleted Successfully");

                    break;

                case 6:

                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}