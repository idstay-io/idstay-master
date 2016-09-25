package idstay.crm;

import idstay.payment.PaymentInventory;
import idstay.profiles.hotelguest.HotelGuestProfile;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hotel_guest_use")
public class HotelGuestUse {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="hotel_guest_use_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name="hotel_guest_profile")
    private HotelGuestProfile hotelGuestProfile;

    @OneToMany
//    @JoinColumn(name="payment_inventory_id")
    private List<PaymentInventory> paymentInventories = new ArrayList<PaymentInventory>();

    //protected HotelGuest() {}
    public HotelGuestUse(final Date date, final HotelGuestProfile hotelGuestProfile) {
        Validate.notNull(date, "date is required");
        Validate.notNull(hotelGuestProfile, "hotelGuestProfile is required");
        this.date = date;
        this.hotelGuestProfile = hotelGuestProfile;
    }

    public Date getDate() {
        return date;
    }

    public HotelGuestProfile getHotelGuestProfile() {
        return hotelGuestProfile;
    }

    public List<PaymentInventory> getPaymentInventory() {
        return paymentInventories;
    }

    public Long getId() {
        return id;
    }

    public void setPaymentInventory(PaymentInventory paymentInventory) {
        for(PaymentInventory payment : paymentInventories) {
            if (paymentInventory.equals(payment.getId())) {
                paymentInventories.remove(paymentInventories.indexOf(payment));
            }
        }
        paymentInventories.add(paymentInventory);
    }

    @Override
    public String toString() {
        return "HotelGuestUse{" +
                "id=" + id +
                ", date=" + date +
                ", hotelGuestProfile=" + hotelGuestProfile +
                ", paymentInventories=" + paymentInventories +
                '}';
    }
}
