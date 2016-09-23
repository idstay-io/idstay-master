package idstay.frontdesk.booking;


import idstay.hotelconfig.hotel.Room;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.booking.support.InValidBookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    @Transactional
    public Optional<Booking> makeReservation(Booking booking) throws InValidBookingException {
        if (!validStay(booking.getRoom(), booking.getStayInformation().getStayPeriod())) {
            throw new InValidBookingException();
        }
        return Optional.of(saveBooking(booking));
    }

    private boolean validStay(final Room room, final StayPeriod stayPeriod) {
        List<Booking> bookingList = bookingRepository.findByRoom(room);
        return bookingList.isEmpty();
    }

    private Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Autowired
    public void setBookingRepository(final BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
