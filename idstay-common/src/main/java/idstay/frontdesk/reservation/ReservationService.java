package idstay.frontdesk.reservation;

import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.RoomAvailabilityService;
import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.booking.StayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */
@Service
public class ReservationService {
    private BookingRepository bookingRepository;
    private RoomAvailabilityService roomAvailabilityService;

    public Optional<Booking> makeReservation(StayInfo stayInfo, Long roomId) {
        Booking booking = new Booking(stayInfo, roomId);
        return Optional.of(bookingRepository.save(booking));
    }

    public Optional<Booking> makeReservation(List<Stay> stays) {
        Booking booking = Booking.newInstance();

        for(Stay stay : stays) {
            booking.withStay(stay);
        }


        return Optional.of(bookingRepository.save(booking));
    }




    @Autowired
    public void setBookingRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Autowired
    public void setRoomAvailabilityService(RoomAvailabilityService roomAvailabilityService) {
        this.roomAvailabilityService = roomAvailabilityService;
    }

}
