package idstay.frontdesk.booking;

import idstay.frontdesk.booking.id.BookingId;
import idstay.frontdesk.booking.request.GuestInfo;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */

@Entity
@Table(name="booking")
public class Booking {
    @EmbeddedId
    private BookingId bookingId;
    protected Booking() {}

    @Embedded
    private GuestInfo guestInfo = new GuestInfo();

    @OneToOne
    @JoinColumn(name = "stay_id")
    private Stay stay;

    public Booking(final BookingId bookingId, final Stay stay) {
        this.bookingId = bookingId;
        this.stay = stay;
    }

    public GuestInfo getGuestInfo() {
        return guestInfo;
    }

    public Stay getStay() {
        return stay;
    }
    public void setStay(Stay stay) {
        this.stay = stay;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", guestInfo=" + guestInfo +
                ", stay=" + stay +
                '}';
    }
}
