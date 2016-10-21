package idstay.facilities.booking.restaurant;

import java.util.Date;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 21.
 */
public class RestaurantBookingRule {
    public static boolean isBookableTime(final Date bookedFromDate, final Date bookedToDate, final Date fromDate, final Date toDate) {
        return (bookedFromDate.compareTo(toDate) >=0 || bookedToDate.compareTo(fromDate) <= 0);
    }


}
