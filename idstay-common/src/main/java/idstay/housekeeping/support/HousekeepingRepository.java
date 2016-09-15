package idstay.housekeeping.support;

import idstay.housekeeping.Housekeeping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HousekeepingRepository extends CrudRepository<Housekeeping, Long>{

    @Query("SELECT DISTINCT h FROM Housekeeping h JOIN FETCH h.room JOIN FETCH h.roomType WHERE h.hotelId = ?1 order by h.sortId")
    List<Housekeeping> findByHotelId(Long hotelId);
}
