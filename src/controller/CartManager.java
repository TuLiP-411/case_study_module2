package controller;

import model.product.interfaces.IDiscount;
import model.product.contents.Meat;
import model.product.contents.Product;
import model.product.contents.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    public static List<Product> listProduct = StockManager.listProduct;
    public static List<Product> listCart = new ArrayList<>();

    //    add sản phẩm theo ID
    public static void addByID(String id, int amount) {
        Product result = null;
        for (Product p : listProduct
        ) {
            if (p.getId().equals(id)) {
                if (amount <= p.getStockAmount()) {
                    p.setBuyAmount(amount);
                    p.setStockAmount(p.getStockAmount() - amount);
                    result = p;
                }
            }
        }
        if (result != null) {
            listCart.add(result);
        } else
            System.out.println("Product ID: " + id + " not found in stock or amount exceeded stock quantity. \nPlease choose another product or add new product to the stock.");
    }

    public static void displayCart() {
        System.out.println();
        System.out.println("******************************---BILL---*****************************");
        System.out.println("Product:\t\tPrice/Unit:\t\tAmount:\t\tDiscount:\t\tPrice:");
        for (Product p : listCart
        ) {
            if (p instanceof Meat || p instanceof Vegetable) {
                System.out.println(p.getName() + " \t " + p.getUnitPrice() + " \t\t " + p.getBuyAmount() + " \t\t " + ((IDiscount) p).getDiscount(p.getBuyAmount()) + " \t\t " + ((IDiscount) p).getRealMoney(p.getBuyAmount()));
            } else {
                System.out.println(p.getName() + " \t " + p.getUnitPrice() + " \t\t " + p.getBuyAmount() + " \t\t 0.0 \t\t " + p.getPrice(p.getBuyAmount()));
            }
        }
    }

    //    xóa sp khỏi giỏ
    public static void deleteProduct(String id) {
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getId().equals(id)) {
                listCart.remove(i);
            }
        }
    }


}
