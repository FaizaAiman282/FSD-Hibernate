package com.example.orderdemo;

/**
 * Hello world!
 *
 */

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderDAO odao = new OrderDAO();

        while (true) {

            System.out.println("\n===== ORDER MENU =====");
            System.out.println("1. Add Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Find Order By ID");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:

                    Orders o = new Orders();

                    System.out.print("Order ID: ");
                    o.setOrderId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Customer Name: ");
                    o.setCustomerName(sc.nextLine());

                    System.out.print("Food Item: ");
                    o.setFoodItem(sc.nextLine());

                    System.out.print("Quantity: ");
                    o.setQuantity(sc.nextInt());

                    System.out.print("Total Amount: ");
                    o.setTotalAmount(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Order Date (yyyy-mm-dd): ");
                    o.setOrderDate(LocalDate.parse(sc.nextLine()));

                    System.out.print("Order Status: ");
                    o.setOrderStatus(sc.nextLine());

                    odao.save(o);

                    System.out.println("Order Added Successfully!");
                    break;

                case 2:

                    System.out.println("\n===== ORDER LIST =====");

                    for (Orders ord : odao.findAll()) {
                        System.out.println(
                                ord.getOrderId() + " | " +
                                ord.getCustomerName() + " | " +
                                ord.getFoodItem() + " | " +
                                ord.getQuantity() + " | " +
                                ord.getTotalAmount() + " | " +
                                ord.getOrderDate() + " | " +
                                ord.getOrderStatus());
                    }

                    break;

                case 3:

                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();

                    Orders found = odao.findById(id);

                    if (found != null) {
                        System.out.println(found.getOrderId() + " " +
                                           found.getCustomerName() + " " +
                                           found.getFoodItem() + " " +
                                           found.getQuantity() + " " +
                                           found.getTotalAmount() + " " +
                                           found.getOrderDate() + " " +
                                           found.getOrderStatus());
                    } else {
                        System.out.println("Order Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Order ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Orders u = new Orders();
                    u.setOrderId(uid);

                    System.out.print("Customer Name: ");
                    u.setCustomerName(sc.nextLine());

                    System.out.print("Food Item: ");
                    u.setFoodItem(sc.nextLine());

                    System.out.print("Quantity: ");
                    u.setQuantity(sc.nextInt());

                    System.out.print("Total Amount: ");
                    u.setTotalAmount(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Order Date (yyyy-mm-dd): ");
                    u.setOrderDate(LocalDate.parse(sc.nextLine()));

                    System.out.print("Order Status: ");
                    u.setOrderStatus(sc.nextLine());

                    odao.update(u);

                    System.out.println("Order Updated!");
                    break;

                case 5:

                    System.out.print("Enter Order ID to delete: ");
                    int did = sc.nextInt();

                    odao.delete(did);

                    System.out.println("Order Deleted!");
                    break;

                case 6:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}
