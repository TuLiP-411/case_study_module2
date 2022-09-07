package controller;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
    public static List<Product> listProduct = new ArrayList<Product>();

    public static void addProduct(Product p) {
        listProduct.add(p);
    }

    public static void editProduct(String id, String newName, double newPrice) {
        for (Product p : listProduct
        ) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setUnitPrice(newPrice);
            }
        }
    }

    public static void deleteProduct(String id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                listProduct.remove(i);
            }

        }
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
