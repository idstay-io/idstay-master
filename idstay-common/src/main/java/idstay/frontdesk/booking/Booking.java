package idstay.frontdesk.booking;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */

@Entity
@Table(name="booking")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="booking_type",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Booking {
    @EmbeddedId
    private BookingId bookingId;

    @Embedded
    private StayInfo stayInfo;

    private Long roomId;
    private Long guestProfileId;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "booking_type")
//    private BookingType bookingType;

//    @OneToMany(orphanRemoval = true)
//    @JoinColumn(name = "booking_id")
//    private List<Stay> stays = new ArrayList<Stay>();

    protected Booking() {}
    public Booking(final BookingId bookingId, final StayInfo stayInfo, final Long roomId) {
        Validate.notNull(bookingId, "bookingId in is required");
        Validate.notNull(stayInfo, "stayInfo in is required");
        Validate.notNull(roomId, "roomId in is required");
        this.bookingId = bookingId;
        this.stayInfo = stayInfo;
        this.roomId = roomId;
    }

    @Transient
    public BookingType getBookingType() {
        String bookingType = this.getClass().getAnnotation(DiscriminatorValue.class).value();
        return BookingType.valueOf(bookingType);
    }

    public BookingId getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", stayInfo=" + stayInfo +
                ", roomId=" + roomId +
                ", guestProfileId=" + guestProfileId +
                '}';
    }
}
