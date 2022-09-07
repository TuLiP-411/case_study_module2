package model.product;

import java.time.LocalDate;
import java.util.Date;

public class Vegetable extends Product implements IExpire, IDiscount {
    private LocalDate manufactureDate;

    public Vegetable() {
    }

    public Vegetable(String id, String name, double unitPrice, LocalDate manufactureDate) {
        super(id, name, unitPrice);
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
    public double getRealMoney() {
        double realMoney;
        if (getExpiryDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("The product is already expired.");
        } else {
            if (getExpiryDate().compareTo(LocalDate.now()) <= 1) {
                realMoney = (getPrice(super.getAmount()) * 50) / 100;
            } else {
                realMoney = getPrice(super.getAmount());
            }
            return realMoney;
        }

    }
}
