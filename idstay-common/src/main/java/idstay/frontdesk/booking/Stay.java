package idstay.frontdesk.booking;

import idstay.frontdesk.common.BookingChannel;
import idstay.hotelconfig.hotel.Room;
import idstay.profiles.hotelguest.HotelGuestProfile;

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

    @Enumerated(EnumType.STRING)
    private BookingChannel bookingChannel;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @OneToOne
    @JoinColumn(name="hotel_guest_profile_id")
    private HotelGuestProfile hotelGuestProfile;


    protected Stay() {}
    public Stay(StayPeriod stayPeriod) {
        this.stayPeriod = stayPeriod;
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
