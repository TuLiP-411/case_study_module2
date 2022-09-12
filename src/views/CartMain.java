package views;

import controller.CartManager;
import controller.StockManager;
import model.product.contents.FactoryProduct;
import model.product.contents.Product;

import java.util.Scanner;

public class CartMain {
    public static void cartPrint() {
        CartManager cartList = new CartManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                menuDisplay();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Input product id to add to cart: ");
                        scanner = new Scanner(System.in);
                        String id = scanner.nextLine();
                        System.out.println("Input buy amount: ");
                        scanner = new Scanner(System.in);
                        int amount = scanner.nextInt();
                        cartList.addByID(id, amount);
                        cartList.displayCart();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Input product id to remove from cart: ");
                        scanner = new Scanner(System.in);
                        id = scanner.nextLine();
                        cartList.deleteProduct(id);
                        cartList.displayCart();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Input user phone number to gain reward point: ");
                        scanner = new Scanner(System.in);
                        String phoneNumber = scanner.nextLine();
                        cartList.addRewardPoint(phoneNumber);
                        cartList.getPayment();
                        cartList.clearCart();
                        try {
                            Thread.sleep(500);
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

    private static void menuDisplay() {
        System.out.println("╔=============================================╗");
        System.out.println("║             CART SHOPPING MENU              ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Add product to cart                  ║");
        System.out.println("║<> [2]. Remove product from cart (by id)     ║");
        System.out.println("║<> [3]. Get payment                          ║");
        System.out.println("║<> [0]. Back to main menu                    ║");
        System.out.println("╚=============================================╝");
    }
}
