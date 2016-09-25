package idstay.payment;

import idstay.common.util.DateTimeUtil;
import idstay.frontdesk.common.Payment;
import idstay.frontdesk.common.PaymentMethods;
import idstay.hotelconfig.hotel.Room;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
@Entity
@Table(name="payment_inventory")
public class PaymentInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="payment_inventory_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Embedded
    private Payment payment;

    protected PaymentInventory() {}
    public PaymentInventory(final PaymentMethods paymentMethods, final Payment payment) {
        this.paymentMethods = paymentMethods;
        this.payment = payment;
        this.timestamp = DateTimeUtil.getLocalDate();
    }

    public void setRoom(final Room room) {
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PaymentInventory{" +
                "id=" + id +
                ", room=" + room +
                ", timestamp=" + timestamp +
                ", paymentMethods=" + paymentMethods +
                ", payment=" + payment +
                '}';
    }
}