package idstay.frontdesk.bookingengine;

import idstay.frontdesk.booking.Stay;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookingRules implements BookingRule{
    public boolean isValid(final Stay bookedStay, final Stay stay) {
        return true;
    }
}
