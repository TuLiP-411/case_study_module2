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
        Product m1 = FactoryProduct.getProduct("M001", "Thit ba chi heo", 300000, 50);
        Product m2 = FactoryProduct.getProduct("M002", "Thit nac vai heo", 320000, 20);
        Product m3 = FactoryProduct.getProduct("M003", "Thit heo xay", 100000, 60);
        Product m4 = FactoryProduct.getProduct("M004", "Thit bo bap", 500000, 50);
        Product m5 = FactoryProduct.getProduct("M005", "Thit bo than", 600000, 30);
        Product m6 = FactoryProduct.getProduct("M006", "Ba chi bo Uc", 250000, 100);
        Product m7 = FactoryProduct.getProduct("M007", "Thit uc ga", 80000, 50);
        Product m8 = FactoryProduct.getProduct("M008", "Thit ga dui", 60000, 50);
        Product m9 = FactoryProduct.getProduct("M009", "Canh ga", 60000, 50);
        Product m10 = FactoryProduct.getProduct("M010", "Ca ro phi phile", 30000, 50);
        ((Meat) m1).setManufactureDate(LocalDate.now());
        ((Meat) m2).setManufactureDate(LocalDate.now());
        ((Meat) m3).setManufactureDate(LocalDate.of(2022, 9, 10));
        ((Meat) m4).setManufactureDate(LocalDate.now());
        ((Meat) m5).setManufactureDate(LocalDate.now());
        ((Meat) m6).setManufactureDate(LocalDate.of(2022, 9, 9));
        ((Meat) m7).setManufactureDate(LocalDate.now());
        ((Meat) m8).setManufactureDate(LocalDate.now());
        ((Meat) m9).setManufactureDate(LocalDate.of(2022, 9, 1));
        ((Meat) m10).setManufactureDate(LocalDate.now());
        Product v1 = FactoryProduct.getProduct("V001", "Rau bap cai", 30000, 15);
        Product v2 = FactoryProduct.getProduct("V002", "Rau muong", 10000, 20);
        Product v3 = FactoryProduct.getProduct("V003", "Rau cai thao", 15000, 20);
        Product v4 = FactoryProduct.getProduct("V004", "Bi do", 20000, 30);
        Product v5 = FactoryProduct.getProduct("V005", "Rau mung toi", 10000, 15);
        ((Vegetable) v1).setManufactureDate(LocalDate.of(2022, 9, 10));
        ((Vegetable) v2).setManufactureDate(LocalDate.of(2022, 9, 10));
        ((Vegetable) v3).setManufactureDate(LocalDate.of(2022, 9, 5));
        ((Vegetable) v4).setManufactureDate(LocalDate.now());
        ((Vegetable) v5).setManufactureDate(LocalDate.now());
        Product s1 = FactoryProduct.getProduct("S001", "Ngu vi huong", 2000, 150);
        Product s2 = FactoryProduct.getProduct("S002", "Bot canh hao hao", 5000, 150);
        Product s3 = FactoryProduct.getProduct("S003", "Nuoc nam Nam Ngu", 23000, 100);
        Product s4 = FactoryProduct.getProduct("S004", "Dau hao", 17000, 150);
        Product s5 = FactoryProduct.getProduct("S005", "Bot nem Ajingon", 32000, 100);

        listProduct.add(m1);
        listProduct.add(m2);
        listProduct.add(m3);
        listProduct.add(m4);
        listProduct.add(m5);
        listProduct.add(m6);
        listProduct.add(m7);
        listProduct.add(m8);
        listProduct.add(m9);
        listProduct.add(m10);
        listProduct.add(v1);
        listProduct.add(v2);
        listProduct.add(v3);
        listProduct.add(v4);
        listProduct.add(v5);
        listProduct.add(s1);
        listProduct.add(s2);
        listProduct.add(s3);
        listProduct.add(s4);
        listProduct.add(s5);
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
            if (p.getId().equals(id)) {
                result = p;
            }
        }
        return result;
    }

}
