package idstay.frontdesk.booking.support;

import idstay.frontdesk.booking.RoomOccupancy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomOccupancyRepository extends JpaRepository<RoomOccupancy, Long>{
}
