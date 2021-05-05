package hust.soict.hedspi.mpayment.web.exception;

public class PaymentExistsException extends RuntimeException {
    public PaymentExistsException(String mess) {
        super(mess);
    }
}
