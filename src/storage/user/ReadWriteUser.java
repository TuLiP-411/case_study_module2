package storage.user;

import model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteUser implements IReadWriteUser {
    public List<User> readData() {
        List<User> UserList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("user.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserList = (List<User>) obj;
        return UserList;
    }

    @Override
    public void writeData(List Users) {
        try {
            FileOutputStream fos = new FileOutputStream("user.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Users);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
