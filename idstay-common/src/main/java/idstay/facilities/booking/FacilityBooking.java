package idstay.facilities.booking;

import idstay.facilities.booking.support.FacilityBookingParam;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */

@Entity
@Table
public class FacilityBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_booking_id")
    private Long id;

    private Long hotelFacilityId;
    private String bookingDate;
    private String fromTime;
    private String toTime;
    private String meme;

    protected FacilityBooking() {}

    public FacilityBooking(final FacilityBookingParam param) {

    }
}
