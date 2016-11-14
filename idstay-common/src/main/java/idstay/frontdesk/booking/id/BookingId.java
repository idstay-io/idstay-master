package idstay.frontdesk.booking.id;

import idstay.common.util.UUIDUtil;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */

@Embeddable
public class BookingId implements Serializable {
    @Column(name = "booking_id")
    private String id;

    public BookingId(final String id) {
        this.id = id;
    }

    public static BookingId newId() {
        return new BookingId(UUIDUtil.getUUID());
    }

    @Override
    public String toString() {
        return "BookingId{" +
                "id='" + id + '\'' +
                '}';
    }
}
