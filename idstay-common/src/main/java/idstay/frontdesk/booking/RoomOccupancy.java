package idstay.frontdesk.booking;


import idstay.hotelconfig.hotel.Room;
import idstay.profiles.hotelguest.HotelGuest;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="room_occupancy")
public class RoomOccupancy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="room_occupancy_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="hotel_guest_id")
    private HotelGuest hotelGuest;

//    @ManyToOne
//    @JoinColumn(name="booking_id")
//    private Booking booking;

    protected RoomOccupancy() {}
    public RoomOccupancy(final Room room, final Date fromDate, final Date toDate) {
        this.room = room;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    /* for Junit only */
    public RoomOccupancy(Long id, final Room room, final Date fromDate, final Date toDate) {
        this(room, fromDate, toDate);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public HotelGuest getHotelGuest() {
        return hotelGuest;
    }

//    public Booking getBooking() {
//        return booking;
//    }

    @Override
    public String toString() {
        return "RoomOccupancy{" +
                "id=" + id +
                ", room=" + room +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", hotelGuest=" + hotelGuest +
//                ", booking=" + booking +
                '}';
    }
}

