package col.example.productdemo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO pdao = new ProductDAO();

        while (true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Find Product by Id");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("Enter id, name, price:");

                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    double price = sc.nextDouble();

                    Product p = new Product();
                    p.setId(id);
                    p.setName(name);
                    p.setPrice(price);

                    pdao.save(p);

                    System.out.println("Product inserted successfully!");
                    break;

                case 2:
                    System.out.println("All Products:");
                    for (Product prod : pdao.findAll()) {
                        System.out.println(prod.getId() + " " +
                                           prod.getName() + " " +
                                           prod.getPrice());
                    }
                    break;

                case 3:
                    System.out.println("Enter product id:");
                    int searchId = sc.nextInt();

                    Product found = pdao.findById(searchId);
                    if (found != null) {
                        System.out.println(found.getId() + " " +
                                           found.getName() + " " +
                                           found.getPrice());
                    } else {
                        System.out.println("Product not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter id to update:");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();

                    System.out.println("Enter new price:");
                    double newPrice = sc.nextDouble();

                    Product up = new Product();
                    up.setId(uid);
                    up.setName(newName);
                    up.setPrice(newPrice);

                    pdao.update(up);
                    System.out.println("Product updated!");
                    break;

                case 5:
                    System.out.println("Enter id to delete:");
                    int did = sc.nextInt();

                    pdao.delete(did);
                    System.out.println("Product deleted!");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}