package model.product.exception;

public class ExpiredProductException extends RuntimeException {
    public ExpiredProductException(String mes) {
        System.out.println(mes);
    }
}
