package idstay.frontdesk.booking;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
@Embeddable
public class BookingId implements Serializable{
    @Column(name = "booking_id")
    private String bookingId;

    protected BookingId() {}
    public BookingId(final String bookingId) {
        this.bookingId = bookingId;
    }

    public String getIdString() {
        return bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId1 = (BookingId) o;
        return bookingId != null ? bookingId.equals(bookingId1.bookingId) : bookingId1.bookingId == null;
    }

    @Override
    public int hashCode() {
        return bookingId != null ? bookingId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "bookingId='" + bookingId + "'";
    }
}
