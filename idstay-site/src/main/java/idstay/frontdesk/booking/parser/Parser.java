package idstay.frontdesk.booking.parser;

import java.util.Date;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public interface Parser {
    String getReservationID();
    String getGuest();
    String getBookedOn();
    String getPhone();
    String getEmail();
    int getCheckIn();
    int getCheckOut();
    int getAdults();
    int getKids();
    String getSpecialRequest();
}
