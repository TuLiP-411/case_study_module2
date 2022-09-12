package views;

import controller.StockManager;
import model.product.contents.Product;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String RESET = "\033[0m";  // Text Reset
        final String RED_BOLD = "\033[1;31m";    // RED
        System.out.println(RED_BOLD  +
                "╔══╗\n" +
                "╚╗╔╝\n" +
                "╔╝(¯`v´¯)\n" +
                "╚══`.¸.[$$$ WELCOME TO TU lINH GROCERY MART $$$]\n" +
                RESET);
        Client.mainMenuPrint();
    }

    public static void mainMenuPrint() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                menuDisplay();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        CartMain.cartPrint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        ProductMain.productMenuPrint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        UserMain.userMenuPrint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 0:
                        System.exit(0);
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
        System.out.println("║           TU LINH GROCERY MART MENU         ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Shopping panel                       ║");
        System.out.println("║<> [2]. Stock management                     ║");
        System.out.println("║<> [3]. User management                      ║");
        System.out.println("║<> [0]. Exit                                 ║");
        System.out.println("╚=============================================╝");
    }
}


