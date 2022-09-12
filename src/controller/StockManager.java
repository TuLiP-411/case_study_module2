package controller;

import model.product.contents.FactoryProduct;
import model.product.contents.Meat;
import model.product.contents.Product;
import model.product.contents.Vegetable;
import storage.product.IReadWriteData;
import storage.product.ReadWriteText;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private static IReadWriteData readFile = ReadWriteText.getInstance();
    public static List<Product> listProduct = new ArrayList<>();

    static {
        Product p1 = FactoryProduct.getProduct("M001", "Thit ba chi", 60000, 350);
        Product p2 = FactoryProduct.getProduct("V001", "Rau bap cai", 15000, 200);
        Product p3 = FactoryProduct.getProduct("S001", "Ngu vi huong", 2000, 150);
        Product p4 = FactoryProduct.getProduct("S002", "Bot canh hao hao", 5000, 150);
        ((Meat) p1).setManufactureDate(LocalDate.now());
        ((Vegetable) p2).setManufactureDate(LocalDate.of(2022, 9, 10));
        listProduct.add(p1);
        listProduct.add(p2);
        listProduct.add(p3);
        listProduct.add(p4);
    }


    public static void addProduct(Product p) {
        if (p != null) {
            listProduct.add(p);
            System.out.println("Product added!");
        }
    }

    public static void editProduct(String id, String newName, double newPrice) {
        for (Product p : listProduct
        ) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setUnitPrice(newPrice);
            }
        }
        System.out.println("Product edited!");
    }

    public static void deleteProduct(String id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                listProduct.remove(i);
            }

        }
        System.out.println("Product removed!");
    }

    public static void displayListProduct() {
        for (Product p : listProduct
        ) {
            System.out.println(p.toString());
        }
    }

    public static Product searchByName(String name) {
        Product result = null;
        for (Product p : listProduct
        ) {
            if (p.getName().equals(name)) {
                result = p;
            }
        }
        return result;
    }

    public static Product searchByID(String id) {
        Product result = null;
        for (Product p : listProduct
        ) {
            if (p.getName().equals(id)) {
                result = p;
            }
        }
        return result;
    }

}
