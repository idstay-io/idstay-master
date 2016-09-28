package idstay.frontdesk.booking;

import idstay.frontdesk.common.BookingChannel;
import idstay.hotelconfig.hotel.Room;
import idstay.profiles.hotelguest.HotelGuestProfile;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */

@Entity
@Table(name="stay")
public class Stay {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Embedded
    private StayPeriod stayPeriod;

    private int adults;
    private int children;

    @Enumerated(EnumType.STRING)
    private BookingChannel bookingChannel;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @OneToOne
    @JoinColumn(name="hotel_guest_profile_id")
    private HotelGuestProfile hotelGuestProfile;

    protected Stay() {}
    public Stay(final StayPeriod stayPeriod, final int adults, final int children) {
        Validate.notNull(stayPeriod, "stayPeriod in is required");
        Validate.notNull(adults, "adults in is required");
        Validate.notNull(children, "children in is required");

        this.stayPeriod = stayPeriod;
        this.adults = adults;
        this.children = children;
    }

    /* for unit test only */
    public Stay(Long id, StayPeriod stayPeriod) {
        this(stayPeriod);
        this.id = id;
    }

    public void setBookingChannel(final BookingChannel bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    public void setHotelGuestProfile(final HotelGuestProfile hotelGuestProfile) {
        this.hotelGuestProfile = hotelGuestProfile;
    }

    public Long getId() {
        return id;
    }

    public StayPeriod getStayPeriod() {
        return stayPeriod;
    }

    public BookingChannel getBookingChannel() {
        return bookingChannel;
    }

    public Room getRoom() {
        return room;
    }

    public HotelGuestProfile getHotelGuestProfile() {
        return hotelGuestProfile;
    }

    @Override
    public String toString() {
        return "Stay{" +
                "id=" + id +
                ", stayPeriod=" + stayPeriod +
                ", bookingChannel=" + bookingChannel +
                ", room=" + room +
                ", hotelGuestProfile=" + hotelGuestProfile +
                '}';
    }
}
