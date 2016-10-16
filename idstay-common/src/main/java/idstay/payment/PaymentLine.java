package idstay.payment;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
@Entity
@Table(name="payment_line")
public class PaymentLine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="payment_line_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Embedded
    private Money money;

    protected PaymentLine() {}
    public PaymentLine(final Date timestamp, final PaymentMethods paymentMethods, final Money money) {
        this.timestamp = timestamp;
        this.paymentMethods = paymentMethods;
        this.money = new Money(money.getCurrancy(), money.getValue());
    }
}