package idstay.frontdesk.booking;


import idstay.configuration.hotel.Room;
import idstay.profiles.hotelguest.HotelGuest;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RoomOccupancy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="room_occupancy_id")
    private long id;

    @ManyToOne
    private Room room;

    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @ManyToOne
    private HotelGuest hotelGuest;

    @ManyToOne
    private Booking booking;

    protected RoomOccupancy() {}
    public RoomOccupancy(final Room room, final Date fromDate, final Date toDate) {

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

    public Booking getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "RoomOccupancy{" +
                "id=" + id +
                ", room=" + room +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", hotelGuest=" + hotelGuest +
                ", booking=" + booking +
                '}';
    }
}

