package idstay.facilities.booking.support;

import idstay.facilities.booking.FacilityBooking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
public interface FacilityBookingRepository extends JpaRepository<FacilityBooking, Long> {
}
