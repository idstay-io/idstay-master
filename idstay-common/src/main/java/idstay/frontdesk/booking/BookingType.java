package idstay.frontdesk.booking;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
public enum BookingType {
    RESERVATION(Values.RESERVATION),
    Walk_in(Values.WALK_IN),
    Comp(Values.COMP);

    private String value;

    BookingType(String bookingType){
        value = bookingType;
    }

    public static class Values {
        public static final String RESERVATION = "RESERVATION";
        public static final String WALK_IN = "WALK_IN";
        public static final String COMP = "COMP";
    }
}
