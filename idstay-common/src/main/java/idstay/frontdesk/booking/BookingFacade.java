package idstay.frontdesk.booking;

import idstay.configuration.hotel.Room;
import idstay.profiles.customer.CustomerService;
import idstay.profiles.hotelguest.HotelGuest;
import idstay.profiles.hotelguest.HotelGuestService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingFacade {
    private BookingRules bookingRules;
    private BookingService bookingService;
    private HotelGuestService hotelGuestService;
    private CustomerService customerService;

    public Optional<Booking> makeBook(final Room room, final StayInformation stayInformation, final HotelGuest hotelGuest, final BookingChannelInformation bookingChannelInformation) {
        Validate.notNull(room, "Room is required");
        Validate.notNull(stayInformation, "Stay Information is required");
        Validate.notNull(hotelGuest, "Hotel Guest is required");
        Validate.notNull(bookingChannelInformation, "booking Channel Information is required");

        if (bookingRules.isValidStay(room, stayInformation) == true) {
            HotelGuest bookingGuest = hotelGuestService.getBookingGuest(hotelGuest);
            Booking booking = new Booking(room, stayInformation, hotelGuest, bookingChannelInformation);
            return bookingService.makeReservation(booking);
        }
        return Optional.empty();
    }

    @Autowired
    public void setBookingService(final BookingService bookingService){
        this.bookingService = bookingService;
    }

    @Autowired
    public void setHotelGuestService(final HotelGuestService hotelGuestService){
        this.hotelGuestService = hotelGuestService;
    }

    @Autowired
    public void setCustomerService(final CustomerService customerService){
        this.customerService = customerService;
    }

    @Autowired
    public void setBookingRules(final BookingRules bookingRules){
        this.bookingRules = bookingRules;
    }
}
