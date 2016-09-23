package idstay.crm;

import idstay.frontdesk.booking.RoomOccupancy;
import idstay.profiles.hotelguest.HotelGuest;

import javax.persistence.*;

@Entity
@Table(name = "hotel_guest_use")
public class HotelGuestUse {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="hotel_guest_use_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="room_occupancy_id")
    private RoomOccupancy roomOccupancy;

    @ManyToOne
    @JoinColumn(name="hotel_guest_id")
    private HotelGuest hotelGuest;

    //protected HotelGuest() {}
    public HotelGuestUse(RoomOccupancy roomOccupancy, HotelGuest hotelGuest) {
        this.roomOccupancy = roomOccupancy;
        this.hotelGuest = hotelGuest;
    }

    /* for junit test only */
    public HotelGuestUse(Long id, RoomOccupancy roomOccupancy, HotelGuest hotelGuest) {
        this(roomOccupancy, hotelGuest);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public RoomOccupancy getRoomOccupancy() {
        return roomOccupancy;
    }

    public HotelGuest getHotelGuest() {
        return hotelGuest;
    }
}
