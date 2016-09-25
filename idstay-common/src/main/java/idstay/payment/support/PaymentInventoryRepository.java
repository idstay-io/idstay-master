package idstay.payment.support;

import idstay.payment.PaymentInventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public interface PaymentInventoryRepository extends JpaRepository<PaymentInventory, Long> {
}
