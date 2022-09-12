package views;

import controller.StockManager;
import controller.UserManager;
import model.product.contents.FactoryProduct;
import model.product.contents.Product;
import model.user.User;

import java.util.Scanner;

public class UserMain {
    public static void userMenuPrint() {
        UserManager userList = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                menuDisplay();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        User user = getUser();
                        userList.addUser(user);
                        System.out.println("User added!");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Input user to edit");
                        System.out.println("Input user phone number to edit: ");
                        scanner = new Scanner(System.in);
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Input new user name: ");
                        scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        userList.editUser(name, phoneNumber);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Input user phone number to remove: ");
                        scanner = new Scanner(System.in);
                        phoneNumber = scanner.nextLine();
                        userList.deleteUser(phoneNumber);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        userList.displayListUser();
                        break;
                    case 5:
                        System.out.println("Input user name to search: ");
                        scanner = new Scanner(System.in);
                        String searchName = scanner.nextLine();
                        User searchUser = userList.searchUserByName(searchName);
                        System.out.println(searchUser.toString());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 6:
                        System.out.println("Input user phone number to search: ");
                        scanner = new Scanner(System.in);
                        String searchPhoneNumber = scanner.nextLine();
                        User searchUser2 = userList.searchUserByPhoneNumber(searchPhoneNumber);
                        System.out.println(searchUser2.toString());
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

    private static User getUser() {
        User user = null;
        try {
            System.out.println("Add new user");
            System.out.println("Input user name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Input user phone number: ");
            scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();
            user = new User(name, phoneNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


    private static void menuDisplay() {
        System.out.println("╔=============================================╗");
        System.out.println("║             USER MANAGING MENU              ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Add new user                         ║");
        System.out.println("║<> [2]. Edit user (by phone number)          ║");
        System.out.println("║<> [3]. Remove user (by phone number)        ║");
        System.out.println("║<> [4]. Display user list                    ║");
        System.out.println("║<> [5]. Search user by name                  ║");
        System.out.println("║<> [6]. Search user by phone number          ║");
        System.out.println("║<> [0]. Back to main menu                    ║");
        System.out.println("╚=============================================╝");
    }
}
