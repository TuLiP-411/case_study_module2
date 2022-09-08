package model.product.contents;

import model.product.exception.IDNotMatchException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactoryProduct {
    private static final String ID_MEAT_REGEX = "^M[0-9]{3}$";
    private static final String ID_VEGETABLE_REGEX = "^V[0-9]{3}$";
    private static final String ID_SPICE_REGEX = "^S[0-9]{3}$";

    public static boolean validateMeat(String regex) {
        Pattern pattern = Pattern.compile(ID_MEAT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateVegetable(String regex) {
        Pattern pattern = Pattern.compile(ID_VEGETABLE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateSpice(String regex) {
        Pattern pattern = Pattern.compile(ID_SPICE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static Product getProduct(String id, String name, double unitPrice, int stockAmount) {
        Product product;
        if (validateMeat(id)) {
            product = new Meat();
        } else if (validateVegetable(id)) {
            product = new Vegetable();
        } else if (validateSpice(id)) {
            product = new Spice();
        } else {
            throw new IDNotMatchException("The ID you have entered is invalid");
        }
        product.setName(name);
        product.setId(id);
        product.setUnitPrice(unitPrice);
        product.setStockAmount(stockAmount);
        return product;
    }
}
