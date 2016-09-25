package idstay.frontdesk.common;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Payment {
    @Enumerated(EnumType.STRING)
    private Currency currancy = Currency.KRW;
    private long totalAmount = 0L;
    private long balance = 0L;
    private long deposit = 0L ;

    protected Payment() {}
    public Payment(final Currency currancy, final long totalAmount) {
        this.currancy = currancy;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "currancy=" + currancy +
                ", totalAmount=" + totalAmount +
                ", balance=" + balance +
                ", deposit=" + deposit +
                '}';
    }
}
