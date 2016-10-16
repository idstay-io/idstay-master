package idstay.backoffice.config.facilities.support;

import idstay.backoffice.config.facilities.HotelFacility;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
public interface HotelFacilityRepository extends JpaRepository<HotelFacility, Long>{
}
