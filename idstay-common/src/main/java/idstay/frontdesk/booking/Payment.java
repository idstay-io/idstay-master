package idstay.frontdesk.booking;

import idstay.frontdesk.common.Currency;
import idstay.frontdesk.common.PaymentMethods;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Payment {
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;
    @Enumerated(EnumType.STRING)
    private Currency currancy = Currency.KRW;
    private long totalAmount;
    private long balance;
    private long deposit;

    protected Payment() {}

    public Payment(PaymentMethods paymentMethods, long totalAmount, long balance) {
        this.paymentMethods = paymentMethods;
        this.totalAmount = totalAmount;
        this.balance = balance;
    }

    public Payment deposit(long balance) {
        this.balance = balance;
        return this;
    }

    public Payment currency(Currency currancy) {
        this.currancy = currancy;
        return this;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public Currency getCurrancy() {
        return currancy;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public long getBalance() {
        return balance;
    }

    public long getDeposit() {
        return deposit;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethods=" + paymentMethods +
                ", currancy=" + currancy +
                ", totalAmount=" + totalAmount +
                ", balance=" + balance +
                ", deposit=" + deposit +
                '}';
    }
}
