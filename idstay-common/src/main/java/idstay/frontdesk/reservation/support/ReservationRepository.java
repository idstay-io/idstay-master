package idstay.frontdesk.reservation.support;

import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.BookingId;
import idstay.frontdesk.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */
public interface ReservationRepository extends JpaRepository<Reservation, BookingId> {
}
