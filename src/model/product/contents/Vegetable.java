package model.product.contents;

import model.product.exception.ExpiredProductException;
import model.product.interfaces.IDiscount;
import model.product.interfaces.IExpire;

import java.io.Serializable;
import java.time.LocalDate;

public class Vegetable extends Product implements IExpire, IDiscount, Serializable {
    private LocalDate manufactureDate;

    protected Vegetable() {
    }

    protected Vegetable(String id, String name, double unitPrice, int stockAmount, LocalDate manufactureDate) {
        super(id, name, unitPrice, stockAmount);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public double getPrice(int amount) {
        return amount * super.getUnitPrice();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufactureDate().plusDays(3);
    }


    @Override
    public double getDiscount(int amount) {
        double discount;
        if (getExpiryDate().isBefore(LocalDate.now())) {
            throw new ExpiredProductException("The product is already expired.");
        } else {
            if (getExpiryDate().compareTo(LocalDate.now()) <= 1) {
                discount = (getPrice(amount) * 40) / 100;
            } else {
                discount = 0;
            }
            return discount;
        }

    }

    public double getRealMoney(int amount) {
        double realMoney = getPrice(getBuyAmount()) - getDiscount(getBuyAmount());
        return realMoney;
    }
}
