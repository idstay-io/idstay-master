package idstay.payment.support;

import idstay.payment.PaymentLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public interface PaymentLineRepository extends JpaRepository<PaymentLine, Long> {
}
