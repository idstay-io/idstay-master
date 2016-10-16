package idstay.facilities.booking.support;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
public class FacilityBookingParam {
    private Long hotelFacilityId;
    private String bookingDate;
    private String fromTime;
    private String toTime;
    private String meme;

    private FacilityBookingParam() {
    }

    public static FacilityBookingParam param() {
        return new FacilityBookingParam();
    }

    public FacilityBookingParam facilityId(final Long hotelFacilityId) {
        this.hotelFacilityId = hotelFacilityId;
        return this;
    }

    public FacilityBookingParam bookingDate(final String bookingDate) {
        this.hotelFacilityId = hotelFacilityId;
        return this;
    }

    public FacilityBookingParam fromTime(final String fromTime) {
        this.fromTime = fromTime;
        return this;
    }

    public FacilityBookingParam toTime(final String toTime) {
        this.toTime = toTime;
        return this;
    }

    public FacilityBookingParam meme(final String meme) {
        this.meme = meme;
        return this;
    }
}
