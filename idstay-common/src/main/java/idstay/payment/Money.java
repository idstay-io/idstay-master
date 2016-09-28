package idstay.payment;

import idstay.frontdesk.common.Currency;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 29.
 */
@Embeddable
public class Money {
    private Long value;
    @Enumerated(EnumType.STRING)
    private Currency currancy = Currency.KRW;

    protected Money() {}
    public Money(Currency currancy, Long value) {
        this(value);
        this.currancy = currancy;
    }

    public Money(Long value) {
        this.value = value;
    }

    public Currency getCurrancy() {
        return this.currancy;
    }

    public Long getValue() {
        return this.value;
    }

}
