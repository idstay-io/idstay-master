package idstay.facilities.booking.restaurant;

import idstay.common.util.DateTimeUtil;
import idstay.facilities.booking.shared.RestaurantTable;

import java.util.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 17.
 */
public class RestaurantBookingParam {
    private Long hotelFacilityId;
    private String bookingDate;
    private Date fromDate;
    private Date toDate;
    private Set<RestaurantTable> restaurantTables = new HashSet<RestaurantTable>();
    private String takeoutItems;
    private boolean stageBooking;

    private RestaurantBookingParam(ParamBuilder builder){
        this.hotelFacilityId = builder.hotelFacilityId;
        this.bookingDate = builder.bookingDate;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
        this.restaurantTables.addAll(builder.restaurantTables);
        this.stageBooking = this.stageBooking;
        this.takeoutItems = builder.takeoutItems;
    }

    public static class ParamBuilder{
        private Long hotelFacilityId;
        private String bookingDate;
        private Date fromDate;
        private Date toDate;
        private Set<RestaurantTable> restaurantTables = new HashSet<RestaurantTable>();
        private String takeoutItems;
        private boolean stageBooking;

        public ParamBuilder(
                final Long hotelFacilityId,
                final String bookingDate,
                final String fromTime,
                final String toTime){

            this.hotelFacilityId = hotelFacilityId;
            this.bookingDate = bookingDate;
            this.fromDate = DateTimeUtil.toDate(bookingDate, fromTime);
            this.toDate = DateTimeUtil.toDate(bookingDate, toTime);
        }

        public ParamBuilder bookingTable(RestaurantTable restaurantTable){
            this.restaurantTables.add(restaurantTable);
            return this;
        }

        private ParamBuilder bookingStage(){
            this.stageBooking = true;
            return this;
        }

        private ParamBuilder takeoutItems(String takeoutItems){
            this.takeoutItems = takeoutItems;
            return this;
        }

        public RestaurantBookingParam build(){
            RestaurantBookingParam param = new RestaurantBookingParam(this);
            return param;
        }
    }

    public RestaurantBooking toBooking(){
        RestaurantBooking booking = new RestaurantBooking(this.hotelFacilityId, this.bookingDate, this.fromDate, this.toDate, "minsoo");
        return booking;
    }

    public Long getHotelFacilityId() {
        return hotelFacilityId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public Set<RestaurantTable> getTables() {
        return restaurantTables;
    }

    public String getTakeoutItems() {
        return takeoutItems;
    }

    public boolean isStageBooking() {
        return stageBooking;
    }
}
