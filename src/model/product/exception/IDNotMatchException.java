package model.product.exception;

public class IDNotMatchException extends RuntimeException{
    public IDNotMatchException(String mes) {
        System.out.println(mes);
    }
}
