package idstay.crm.support;

import idstay.crm.HotelGuestSpending;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 28.
 */
public interface HotelGuestSpendingRepository extends JpaRepository<HotelGuestSpending, Long> {
}
