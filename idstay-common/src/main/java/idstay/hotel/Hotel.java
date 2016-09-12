package idstay.hotel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private long id;
    private String hotelName;

    protected Hotel() {
    }

    public Hotel(final long id) {
        this.id = id;
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Hotel)) {
            return false;
        }

        return (id == ((Hotel) object).id) ? true : false;
    }

    public int hashCode() {
        return (int) id;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("hotelName", hotelName)
                .toString();
    }
}
