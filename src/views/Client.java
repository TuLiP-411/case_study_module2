package views;

import controller.StockManager;
import model.product.contents.Product;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
            StockManager productList = new StockManager();
            int choice = -1;
            Scanner scanner = new Scanner(System.in);
            while (choice != 0) {
                menuDisplay();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Product product = getProduct();
                        productList.addProduct(product);
                        System.out.println("Product added!");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Input product to edit");
                        System.out.println("Input product id to edit: ");
                        scanner = new Scanner(System.in);
                        int id = scanner.nextInt();
                        System.out.println("Input new product name: ");
                        scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        System.out.println("Input new product price: ");
                        scanner = new Scanner(System.in);
                        double price = scanner.nextDouble();
                        productList.editProduct(id, name, price);
                        System.out.println("Product edited!");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Input product id to remove: ");
                        scanner = new Scanner(System.in);
                        id = scanner.nextInt();
                        productList.deleteProduct(id);
                        System.out.println("Product removed!");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        productList.displayListProduct();
                        break;
                    case 5:
                        System.out.println("Input product name to search: ");
                        scanner = new Scanner(System.in);
                        String searchName = scanner.nextLine();
                        Product searchProduct = productList.searchByName(searchName);
                        System.out.println("Product found!");
                        System.out.println(searchProduct.toString());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("No choice!");
                }
            }

        }

        private static Product getProduct() {
            System.out.println("Add new product");
            System.out.println("Input product id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            System.out.println("Input product name: ");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Input product price: ");
            scanner = new Scanner(System.in);
            double price = scanner.nextDouble();
            Product product1 = new Product(id, name, price);
            return product1;
        }

        private static void menuDisplay() {
            System.out.println("***********************");
            System.out.println("MENU");
            System.out.println("Choose action bellow: ");
            System.out.println("----------***------------");
            System.out.println("1. Add product");
            System.out.println("2. Edit product name (by id)");
            System.out.println("3. Remove product (by id)");
            System.out.println("4. Display product list");
            System.out.println("5. Search product by name");
            System.out.println("0. Exit");
        }
    }
}
