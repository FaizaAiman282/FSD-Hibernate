package com.example.bookdemo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO bdao = new BookDAO();

        while (true) {

            System.out.println("\n===== BOOK MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Find Book By ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // IMPORTANT FIX

            switch (ch) {

                case 1:
                    Book b = new Book();

                    System.out.print("Book ID: ");
                    b.setBookId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Title: ");
                    b.setTitle(sc.nextLine());

                    System.out.print("Author: ");
                    b.setAuthor(sc.nextLine());

                    System.out.print("Category: ");
                    b.setCategory(sc.nextLine());

                    System.out.print("Price: ");
                    b.setPrice(sc.nextDouble());

                    System.out.print("Available Copies: ");
                    b.setAvailableCopies(sc.nextInt());
                    sc.nextLine();

                    bdao.save(b);
                    System.out.println("Book Added!");
                    break;

                case 2:
                    for (Book book : bdao.findAll()) {
                        System.out.println(
                                book.getBookId() + " | " +
                                book.getTitle() + " | " +
                                book.getAuthor() + " | " +
                                book.getCategory() + " | " +
                                book.getPrice() + " | " +
                                book.getAvailableCopies());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    Book f = bdao.findById(id);

                    if (f != null)
                        System.out.println(f.getTitle());
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Book ub = new Book();
                    ub.setBookId(uid);

                    System.out.print("New Title: ");
                    ub.setTitle(sc.nextLine());

                    System.out.print("New Author: ");
                    ub.setAuthor(sc.nextLine());

                    System.out.print("New Category: ");
                    ub.setCategory(sc.nextLine());

                    System.out.print("New Price: ");
                    ub.setPrice(sc.nextDouble());

                    System.out.print("New Copies: ");
                    ub.setAvailableCopies(sc.nextInt());
                    sc.nextLine();

                    bdao.update(ub);
                    System.out.println("Updated!");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    bdao.delete(did);
                    System.out.println("Deleted!");
                    break;

                case 6:
                    System.out.println("Exit...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}