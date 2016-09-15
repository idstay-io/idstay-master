package idstay.profiles.hotelguest;


import idstay.profiles.customer.Customer;

import javax.persistence.*;

@Entity
public class HotelGuest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="hotel_guest_id")
    private long id;

    private String firstName;
    private String lastName;
    private String guestName;
    private String email;

    protected HotelGuest() {}
    public HotelGuest(final String guestName) {
        this.guestName = guestName;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String name) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean identifiable() {
        return (email != null)? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelGuest)) return false;

        HotelGuest that = (HotelGuest) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "HotelGuest{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static HotelGuest build(Customer customer) {
        return new HotelGuest(customer.getEmail());
    }
}
