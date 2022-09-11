package model.product.contents;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String id;
    private String name;
    private double unitPrice;
    private int stockAmount;

    private int buyAmount;

    public Product() {
    }

    public Product(String id, String name, double unitPrice, int stockAmount) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockAmount = stockAmount;
    }

    public Product(int amount) {
        this.stockAmount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public abstract double getPrice(int amount);

    @Override
    public String toString() {
        return "Product {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", stockAmount=" + stockAmount +
                '}';
    }
}

