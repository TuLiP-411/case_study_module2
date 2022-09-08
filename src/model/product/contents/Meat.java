package model.product.contents;

import model.product.exception.ExpiredProductException;
import model.product.interfaces.IDiscount;
import model.product.interfaces.IExpire;

import java.time.LocalDate;

public class Meat extends Product implements IExpire, IDiscount {
    private LocalDate manufactureDate;


    public Meat() {
    }

    public Meat(String id, String name, double unitPrice, int stockAmount, LocalDate manufactureDate) {
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
        return getManufactureDate().plusDays(5);
    }

    @Override
    public double getDiscount(int amount) {
        double discount;
        if (getExpiryDate().isBefore(LocalDate.now())) {
            throw new ExpiredProductException("The product is already expired.");
        } else {
            if (getExpiryDate().compareTo(LocalDate.now()) <= 3) {
                discount = (getPrice(amount) * 30) / 100;
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
