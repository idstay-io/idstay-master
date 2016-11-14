package idstay.guestmanagement;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
@Entity
@Table(name="guest_profile")
public class GuestProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="guest_profile_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String guestName;
    private String email;

    protected GuestProfile() {}
    public GuestProfile(final String email, final String guestName) {
        Validate.notNull(email, "email is required");
        Validate.notNull(guestName, "guestName is required");

        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuestProfile)) return false;

        GuestProfile that = (GuestProfile) o;
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

    public boolean isIdentifiable() {
        return this.email != null && this.getGuestName() != null;
    }
}
