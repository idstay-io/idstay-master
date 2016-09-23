package idstay.frontdesk.booking.support;

import idstay.hotelconfig.hotel.Room;
import idstay.frontdesk.booking.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByRoom(Room room);
}
