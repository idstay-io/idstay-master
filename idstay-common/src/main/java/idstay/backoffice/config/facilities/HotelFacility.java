package idstay.backoffice.config.facilities;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
@Entity
@Table(name="hotel_facility")
public class HotelFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_facility_id")
    private Long id;
    private String hotelFacilityName;

    protected HotelFacility() {}

    public HotelFacility(final String hotelFacilityName) {
        this.hotelFacilityName = hotelFacilityName;
    }

    public Long getId() {
        return id;
    }

    public String getHotelFacilityName() {
        return hotelFacilityName;
    }
}
