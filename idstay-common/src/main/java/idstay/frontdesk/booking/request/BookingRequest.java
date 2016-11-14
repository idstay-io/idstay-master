package idstay.frontdesk.booking.request;

import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.support.BookingRepository;
import org.apache.commons.lang3.Validate;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 9.
 */

public class BookingRequest {
    private Long roomId;
    private GuestInfo guestInfo = new GuestInfo();
    private StayInfo stayInfo = new StayInfo();

    public static BookingRequest newInstance() {
        return new BookingRequest();
    }

    public BookingRequest roomId(Long roomId) {
        Validate.notNull(roomId, "roomId  is required");
        this.roomId = roomId;
        return this;
    }

    public StayInfo getStayInfo() {
        return this.stayInfo;
    }

    public GuestInfo getGuestInfo() {
        return this.guestInfo;
    }

    public Stay stay() {


    }
}
