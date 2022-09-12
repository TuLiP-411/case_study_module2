package views;

//import com.sun.tools.javac.Main;

import controller.StockManager;
import model.product.contents.FactoryProduct;
import model.product.contents.Meat;
import model.product.contents.Product;
import model.product.contents.Vegetable;
import model.product.exception.IDNotMatchException;

import java.time.LocalDate;
import java.util.Scanner;

public class ProductMain {
    public static void productMenuPrint() {
        StockManager productList = new StockManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                menuDisplay();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Product product = getProduct();
                        if (product instanceof Meat) {
                            System.out.println("Input manufacture year:");
                            scanner = new Scanner(System.in);
                            int year = scanner.nextInt();
                            System.out.println("Input manufacture month:");
                            scanner = new Scanner(System.in);
                            int month = scanner.nextInt();
                            System.out.println("Input manufacture day:");
                            scanner = new Scanner(System.in);
                            int day = scanner.nextInt();
                            ((Meat) product).setManufactureDate(LocalDate.of(year, month, day));
                        }
                        if (product instanceof Vegetable) {
                            System.out.println("Input manufacture year:");
                            scanner = new Scanner(System.in);
                            int year = scanner.nextInt();
                            System.out.println("Input manufacture month:");
                            scanner = new Scanner(System.in);
                            int month = scanner.nextInt();
                            System.out.println("Input manufacture day:");
                            scanner = new Scanner(System.in);
                            int day = scanner.nextInt();
                            ((Vegetable) product).setManufactureDate(LocalDate.of(year, month, day));
                        }
                        productList.addProduct(product);
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
                        String id = scanner.nextLine();
                        System.out.println("Input new product name: ");
                        scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        System.out.println("Input new product price/unit: ");
                        scanner = new Scanner(System.in);
                        double price = scanner.nextDouble();
                        productList.editProduct(id, name, price);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Input product id to remove: ");
                        scanner = new Scanner(System.in);
                        id = scanner.nextLine();
                        productList.deleteProduct(id);
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
                        System.out.println(searchProduct.toString());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 6:
                        System.out.println("Input product ID to search: ");
                        scanner = new Scanner(System.in);
                        String searchID = scanner.nextLine();
                        Product searchProduct2 = productList.searchByID(searchID);
                        System.out.println(searchProduct2.toString());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 0:
                        Client.mainMenuPrint();
                    default:
                        System.out.println("No choice!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Product getProduct() {
        Product product = null;
        try {
            System.out.println("Add new product");
            System.out.println("Input product id: ");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            System.out.println("Input product name: ");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Input product price/unit: ");
            scanner = new Scanner(System.in);
            double price = scanner.nextDouble();
            System.out.println("Input product stock amount: ");
            scanner = new Scanner(System.in);
            int amount = scanner.nextInt();
            product = FactoryProduct.getProduct(id, name, price, amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }


    private static void menuDisplay() {
        System.out.println("╔=============================================╗");
        System.out.println("║             STOCK MANAGING MENU             ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Add product to stock                 ║");
        System.out.println("║<> [2]. Edit product in stock (by id)        ║");
        System.out.println("║<> [3]. Remove product from stock (by id)    ║");
        System.out.println("║<> [4]. Display product stock list           ║");
        System.out.println("║<> [5]. Search stock product by name         ║");
        System.out.println("║<> [6]. Search stock product by ID           ║");
        System.out.println("║<> [0]. Back to main menu                    ║");
        System.out.println("╚=============================================╝");
    }
}



