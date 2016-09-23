package idstay.profiles.hotelguest;


import idstay.profiles.customer.IdstayCustomer;

import javax.persistence.*;

@Entity
@Table(name="hotel_guest")
public class HotelGuest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="hotel_guest_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String guestName;
    private String email;

    protected HotelGuest() {}
    public HotelGuest(final String guestName) {
        this.guestName = guestName;
    }

    /* for unit test only */
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public static HotelGuest build(IdstayCustomer customer) {
        return new HotelGuest(customer.getEmail());
    }
}
