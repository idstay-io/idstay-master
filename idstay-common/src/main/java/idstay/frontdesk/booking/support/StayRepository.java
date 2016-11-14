package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.StayPeriod;
import idstay.frontdesk.booking.id.StayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public interface StayRepository extends JpaRepository<Stay, StayId> {
    List<Stay> findByStayId(StayId id);

    @Query("SELECT s FROM Stay s INNER JOIN s.stayPeriod peroid WHERE s.roomId = ?1 AND (( peroid.checkin BETWEEN ?2 AND ?3 ) OR ( peroid.checkout BETWEEN ?2 AND ?3 ))")
    List<Stay> findRegisteredStay(Long roomId, int checkin, int checkout);
}
