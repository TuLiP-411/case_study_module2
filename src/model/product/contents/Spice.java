package model.product.contents;

public class Spice extends Product {
    public Spice() {
    }

    public Spice(String id, String name, double unitPrice, int stockAmount) {
        super(id, name, unitPrice, stockAmount);
    }

    @Override
    public double getPrice(int amount) {
        return amount * super.getUnitPrice();
    }
}
