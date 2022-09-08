package controller;

import model.product.contents.Product;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
    public static List<Product> listProduct = new ArrayList<>();
//    Product p1 = FactoryProduct.getProduct("M001","Thit ba chi",60000, 350);
//    Product p2 = FactoryProduct.getProduct("V001","Rau bap cai",15000, 200);
//    Product p3 = FactoryProduct.getProduct("S001","Ngu vi huong",2000,150);
//    Product p4 = FactoryProduct.getProduct("S002","Bot canh hao hao",5000,150);
//

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
