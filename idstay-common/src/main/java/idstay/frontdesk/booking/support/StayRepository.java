package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public interface StayRepository extends JpaRepository<Stay, Long>{
}
