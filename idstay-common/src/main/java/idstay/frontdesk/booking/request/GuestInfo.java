package idstay.frontdesk.booking.request;

import javax.persistence.Embeddable;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 8.
 */
@Embeddable
public class GuestInfo {
    private String guestName;
    private String email;
    private String phone;
    private String nationality;

    public GuestInfo() {}

    public GuestInfo guestName(final String guestName) {
        this.guestName = guestName;
        return this;
    }

    public GuestInfo email(final String email) {
        this.email = email;
        return this;
    }

    public GuestInfo phone(final String phone) {
        this.phone = phone;
        return this;
    }

    public GuestInfo nationality(final String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isIdentifiable() {
        return guestName != null && !"".equals(guestName) && email != null && !"".equals(email);
    }

    @Override
    public String toString() {
        return "GuestInfo{" +
                "guestName='" + guestName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
