package controller;

import model.user.User;
import storage.product.IReadWriteData;
import storage.product.ReadWriteText;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static IReadWriteData readFile = ReadWriteText.getInstance();
    public static List<User> listUser = new ArrayList<>();

    static {
        User u1 = new User("Luong", "0915814526", 15);
        User u2 = new User("Linh", "0388205097", 20);
        listUser.add(u1);
        listUser.add(u2);
    }

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

    public static void displayListUser() {
        for (User u : listUser
        ) {
            System.out.println(u.toString());
        }
    }

    public static User searchUserByName(String name) {
        User result = null;
        for (User u : listUser
        ) {
            if (u.getName().equals(name)) {
                result = u;
            }
        }
        return result;
    }

    public static User searchUserByPhoneNumber(String phoneNumber) {
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
