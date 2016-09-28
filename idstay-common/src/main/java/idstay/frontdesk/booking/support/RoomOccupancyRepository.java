package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.StayLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface RoomOccupancyRepository extends JpaRepository<StayLine, Long>{
    @Query("SELECT r FROM RoomOccupancy r WHERE ?1 between r.fromDate and r.toDate")
    List<StayLine> findByDate(Date date);
}
