package idstay.frontdesk.booking.support;

public class InValidBookingException extends RuntimeException {

    public InValidBookingException(String message) {
        super(message);
    }
}