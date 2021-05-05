package hust.soict.hedspi.morder.web.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String mess) {
        super(mess);
    }
}
