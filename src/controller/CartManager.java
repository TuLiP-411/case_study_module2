package controller;

import model.product.interfaces.IDiscount;
import model.product.contents.Meat;
import model.product.contents.Product;
import model.product.contents.Vegetable;
import model.user.User;
import storage.product.IReadWriteData;
import storage.product.ReadWriteText;

import java.util.ArrayList;
import java.util.List;

import static controller.UserManager.listUser;

public class CartManager {
    private static IReadWriteData readFile = ReadWriteText.getInstance();
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
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("                       TU LINH GROCERY MART      %n");
        System.out.printf("                           SHOPPING BILL        %n");

        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %-20s | %-10s | %-7s | %-10s | %-10s |%n", "PRODUCT", "PRICE/UNIT", "AMOUNT", "DISCOUNT", "PRICE");
        System.out.printf("-------------------------------------------------------------------------%n");

        for (Product p : listCart
        ) {
            if (p instanceof Meat || p instanceof Vegetable) {
                System.out.printf("| %-20s | %-10s | %-7s | %-10s | %-10s |%n", p.getName(), p.getUnitPrice(), p.getBuyAmount(), ((IDiscount) p).getDiscount(p.getBuyAmount()), ((IDiscount) p).getRealMoney(p.getBuyAmount()));
            } else {
                System.out.printf("| %-20s | %-10s | %-7s | %-10s | %-10s |%n", p.getName(), p.getUnitPrice(), p.getBuyAmount(), "0.0", p.getPrice(p.getBuyAmount()));
            }
        }
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %56s | %-10s |%n", "TOTAL:", getTotal());
        System.out.printf("-------------------------------------------------------------------------%n");
    }

    //    xóa sp khỏi giỏ
    public static void deleteProduct(String id) {
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getId().equals(id)) {
                listCart.remove(i);
            }
        }
    }

    public static double getTotal() {
        double sum = 0;
        for (Product p : listCart
        ) {
            if (p instanceof Meat || p instanceof Vegetable) {
                sum += ((IDiscount) p).getRealMoney(p.getBuyAmount());
            } else {
                sum += p.getPrice(p.getBuyAmount());
            }
        }
        return sum;
    }

    public static int calculateRewardPoint() {
        int rewardPoint = (int) (getTotal() / 1000);
        return rewardPoint;
    }

    public static void addRewardPoint(String phoneNumber) {
        for (User u : listUser
        ) {
            if (u.getPhoneNumber().equals(phoneNumber)) {
                u.addPoint(calculateRewardPoint());
            }
        }
    }
}

