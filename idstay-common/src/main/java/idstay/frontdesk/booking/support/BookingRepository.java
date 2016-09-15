package idstay.frontdesk.booking.support;

import idstay.configuration.hotel.Room;
import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.StayPeriod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByRoom(Room room);
}
