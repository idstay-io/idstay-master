package idstay.frontdesk.booking;

import idstay.hotelconfig.hotel.Room;
import idstay.profiles.hotelguest.HotelGuest;
import org.apache.commons.lang3.Validate;
import javax.persistence.*;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="booking_id")
    private Long id;

    @Embedded
    private StayInformation stayInformation;

    @ManyToOne
    @JoinColumn(name="hotel_guest_id")
    private HotelGuest hotelGuest;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

//    @OneToMany(fetch=FetchType.LAZY, mappedBy = "room_occupancy_id")
//    private Collection<StayLine> roomOccupancies;

    @Embedded
    private BookingChannelInformation bookingChannelInformation;

    protected Booking() {}

    /* only for unit test */
    public Booking(final Room room, final StayInformation stayInformation, final HotelGuest hotelGuest, final BookingChannelInformation bookingChannelInformation) {
        Validate.notNull(room, "Room is required");
        Validate.notNull(stayInformation, "Stay Information is required");
        Validate.notNull(hotelGuest, "Hotel Guest is required");
        Validate.notNull(bookingChannelInformation, "booking Channel Information is required");

        this.room = room;
        this.stayInformation = stayInformation;
        this.hotelGuest = hotelGuest;
        this.bookingChannelInformation = bookingChannelInformation;
    }

    /* only for unit test */
    public Booking(final Long id, final Room room, final StayInformation stayInformation, final HotelGuest hotelGuest, final BookingChannelInformation bookingChannelInformation) {
        this(room, stayInformation, hotelGuest, bookingChannelInformation);
        this.id = id;
    }




    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public StayInformation getStayInformation() {
        return stayInformation;
    }

    public HotelGuest getHotelGuest() {
        return hotelGuest;
    }

    public BookingChannelInformation getBookingChannelInformation() {
        return bookingChannelInformation;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", stayInformation=" + stayInformation +
                ", hotelGuest=" + hotelGuest +
                ", room=" + room +
                ", bookingChannelInformation=" + bookingChannelInformation +
                '}';
    }
}
