package storage.product;

import model.product.contents.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteData {
    public List<Product> readData() {
        List<Product> productList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("product.dat");
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
        productList = (List<Product>) obj;
        return productList;
    }


    public void writeData(List<Product> Products) {
        try {
            FileOutputStream fos = new FileOutputStream("product.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Products);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
