package idstay.housekeeping.support;

import idstay.housekeeping.HousekeepingHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HousekeepingHistoryRepository extends CrudRepository<HousekeepingHistory, Long>{

    @Query("SELECT h FROM HousekeepingHistory h WHERE h.lastUpdate BETWEEN ?1 AND ?2 ORDER BY h.lastUpdate DESC")
    public Optional<List<HousekeepingHistory>> findHistory(Date fromDate, Date toDate);
}