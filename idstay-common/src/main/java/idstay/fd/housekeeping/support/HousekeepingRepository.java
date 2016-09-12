package idstay.fd.housekeeping.support;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idstay.fd.housekeeping.Housekeeping;
import idstay.hotel.Hotel;

public interface HousekeepingRepository extends CrudRepository<Housekeeping, Long>{

    @Query("SELECT DISTINCT h FROM Housekeeping h JOIN FETCH h.room JOIN FETCH h.roomType WHERE h.hotelId = ?1 order by h.sortId")
    List<Housekeeping> findByHotelId(Long hotelId);
}
