package idstay.testutils;

import idstay.frontdesk.booking.StayLine;
import idstay.hotelconfig.hotel.Room;
import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.BookingChannelInformation;
import idstay.frontdesk.booking.StayInformation;
import idstay.profiles.hotelguest.HotelGuest;

import java.util.Collection;

public class BookingBuilder {
    private Long id;
    private StayInformation stayInformation;
    private HotelGuest hotelGuest;
    private Room room;
    private Collection<StayLine> roomOccupancies;
    private BookingChannelInformation bookingChannelInformation;

    private BookingBuilder() {}
    public static BookingBuilder booking() {
        return new BookingBuilder();
    }

    public BookingBuilder id(Long id){
        this.id = id;
        return this;
    }

    public BookingBuilder stayInformation(StayInformation stayInformation){
        this.stayInformation = stayInformation;
        return this;
    }

    public BookingBuilder hotelGuest(HotelGuest hotelGuest){
        this.hotelGuest = hotelGuest;
        return this;
    }

    public BookingBuilder room(Room room){
        this.room = room;
        return this;
    }

    public BookingBuilder roomOccupancies(Collection<StayLine> roomOccupancies){
        this.roomOccupancies = roomOccupancies;
        return this;
    }

    public BookingBuilder bookingChannelInformation(BookingChannelInformation bookingChannelInformation){
        this.bookingChannelInformation = bookingChannelInformation;
        return this;
    }

    public Booking build() {
        return new Booking(id, room, stayInformation, hotelGuest, bookingChannelInformation);
    }


}
