package model.product.contents;

import java.io.Serializable;

public class Spice extends Product implements Serializable {
    protected Spice() {
    }

    protected Spice(String id, String name, double unitPrice, int stockAmount) {
        super(id, name, unitPrice, stockAmount);
    }

    @Override
    public double getPrice(int amount) {
        return amount * super.getUnitPrice();
    }
}
