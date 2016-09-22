package idstay.testutils;

import idstay.common.util.DateTimeUtil;
import idstay.configuration.hotel.Room;
import idstay.frontdesk.booking.RoomOccupancy;
import idstay.profiles.hotelguest.HotelGuest;

import java.util.Date;

public class RoomOccupancyBuilder {
    private long id;
    private Room room;
    private Date fromDate;
    private Date toDate;
    private HotelGuest hotelGuest;

    public RoomOccupancyBuilder() {
        this.id = 1L;
        this.room = RoomBuilder.room().build();
        this.fromDate = DateTimeUtil.getLocalDate();
        this.toDate = DateTimeUtil.getLocalDate();
        this.hotelGuest = HotelGuestBuilder.hotelGuest().build();
    }

    public static RoomOccupancyBuilder roomOccupancy() {
        return new RoomOccupancyBuilder();
    }

    public RoomOccupancyBuilder id(long id) {
        this.id = id;
        return this;
    }

    public RoomOccupancyBuilder room(Room room) {
        this.room = room;
        return this;
    }

    public RoomOccupancyBuilder fromDate(Date fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public RoomOccupancyBuilder toDate(Date toDate) {
        this.toDate = toDate;
        return this;
    }

    public RoomOccupancyBuilder hotelGuest(HotelGuest hotelGuest) {
        this.hotelGuest = hotelGuest;
        return this;
    }

    public RoomOccupancy build() {
        return new RoomOccupancy(id, room, fromDate, toDate);

    }
}