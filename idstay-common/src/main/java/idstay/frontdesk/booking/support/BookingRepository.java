package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.id.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public interface BookingRepository extends JpaRepository<Booking, BookingId> {
}
