package idstay.crm;

import idstay.frontdesk.booking.Stay;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 28.
 */
@Entity
@Table(name="hotel_guest_spending")
public class HotelGuestSpending {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="hotel_guest_spending_id")
    private Long id;
    
    @Column(name="stay_id")
    private Long stayId;

    @ElementCollection
    @CollectionTable(name="guest_payment_line", joinColumns = @JoinColumn(name="payment_line_id"))
    private Set<Long> paymentLines = new HashSet<Long>();

    protected HotelGuestSpending() {};
    
    public HotelGuestSpending(final Stay stay) {
        Validate.notNull(stay.getHotelGuestProfile().getId(), "hotelGuestProfileId is required");
        this.stayId = stay.getId();
    }

    public Set<Long> addPayment(Long paymentId) {
        this.paymentLines.add(paymentId);

        return this.paymentLines;
    }

    public void addPaymentLines(List<Long> paymentLines) {
        if(paymentLines.isEmpty())
            this.paymentLines.addAll(paymentLines);
    }


    public Long getId() {
        return id;
    }
}
