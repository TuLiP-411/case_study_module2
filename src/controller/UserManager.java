package controller;

import model.product.contents.Product;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static List<User> listUser = new ArrayList<>();

    public static void addUser(User u) {
        listUser.add(u);
    }

    public static void editUser(String newName, String phoneNumber) {
        for (User u : listUser
        ) {
            if (phoneNumber.equals(phoneNumber)) {
                u.setName(newName);
                u.setPhoneNumber(phoneNumber);
            }
        }
    }

    public static void deleteUser(String phoneNumber) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getPhoneNumber().equals(phoneNumber)) {
                listUser.remove(i);
            }

        }
    }

    public static void displayListProduct() {
        for (User u : listUser
        ) {
            System.out.println(u.toString());
        }
    }

    public static User searchByName(String name) {
        User result = null;
        for (User u : listUser
        ) {
            if (u.getName().equals(name)) {
                result = u;
            }
        }
        return result;
    }

    public static User searchByPhoneNumber(String phoneNumber) {
        User result = null;
        for (User u : listUser
        ) {
            if (u.getPhoneNumber().equals(phoneNumber)) {
                result = u;
            }
        }
        return result;
    }

}
