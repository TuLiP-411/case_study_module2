package controller;

import model.product.contents.FactoryProduct;
import model.product.contents.Meat;
import model.product.contents.Product;
import model.product.contents.Vegetable;
import model.product.exception.ExpiredProductException;
import model.product.exception.IDNotMatchException;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        StockManager stockList = new StockManager();
        try {
            Product p1 = FactoryProduct.getProduct("M001", "Thit ba chi", 60000, 350);
            Product p2 = FactoryProduct.getProduct("V001", "Rau bap cai", 15000, 200);
            Product p3 = FactoryProduct.getProduct("S001", "Ngu vi huong", 2000, 150);
            Product p4 = FactoryProduct.getProduct("S002", "Bot canh hao hao", 5000, 150);
            ((Meat) p1).setManufactureDate(LocalDate.now());
            ((Vegetable) p2).setManufactureDate(LocalDate.of(2022, 9, 9));
            stockList.addProduct(p1);
            stockList.addProduct(p2);
            stockList.addProduct(p3);
            stockList.addProduct(p4);
            stockList.displayListProduct();

            CartManager cartManager = new CartManager();
            cartManager.addByID("M001", 20);
            cartManager.addByID("V001", 150);
            cartManager.addByID("S002", 100);

            cartManager.displayCart();

        } catch (IDNotMatchException e) {
            System.out.println(e);
        } catch (ExpiredProductException e) {
            e.printStackTrace();
        }

    }
}
