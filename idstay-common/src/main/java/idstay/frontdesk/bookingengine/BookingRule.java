package idstay.frontdesk.bookingengine;

import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.StayPeriod;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public interface BookingRule {
    boolean isValid(final Stay bookedStay, final Stay stay);
}
