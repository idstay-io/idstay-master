package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
