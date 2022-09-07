package model.product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactoryProduct {
    private static final String ID_MEAT_REGEX = "^M[0-9]{3}$";
    private static final String ID_VEGETABLE_REGEX = "^V[0-9]{3}$";
    private static final String ID_SPICE_REGEX = "^S[0-9]{3}$";

    public boolean validateMeat(String regex) {
        Pattern pattern = Pattern.compile(ID_MEAT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateVegetable(String regex) {
        Pattern pattern = Pattern.compile(ID_VEGETABLE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateSpice(String regex) {
        Pattern pattern = Pattern.compile(ID_SPICE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public Product getProduct(String id) {
        if (validateMeat(id)) {
            return new Meat();
        } else if (validateVegetable(id)) {
            return new Vegetable();
        } else if (validateSpice(id)) {
            return new Spice();
        } else {
            throw new IDNotMatchException("The ID you have entered is invalid");
        }
    }
}
