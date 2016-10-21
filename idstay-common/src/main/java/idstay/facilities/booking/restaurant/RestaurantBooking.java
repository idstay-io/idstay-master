package idstay.facilities.booking.restaurant;


import idstay.facilities.booking.shared.RestaurantTable;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */

@Entity
@Table
public class RestaurantBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_booking_id")
    private Long id;

    private Long hotelFacilityId;
    private String bookingDate;
    @Temporal(TemporalType.TIME)
    private Date fromTime;
    @Temporal(TemporalType.TIME)
    private Date toTime;
    private String note;

    private String guest;
    private String phoneNumber;

    private String author;

    private String payedBy;
    private String payment;

    @ElementCollection(targetClass=RestaurantTable.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="restarant_booking_tables", joinColumns = @JoinColumn(name="table_id"))
    @Column(name="remarks")
    @Fetch(FetchMode.SUBSELECT)
    Set<RestaurantTable> tables = new HashSet<RestaurantTable>();

    @Transient
    private RestaurantBookingRule rule;


    protected RestaurantBooking() {}
    public RestaurantBooking(final Long hotelFacilityId, final String bookingDate, final Date fromTime, final Date toTime, final String guest){
        this.hotelFacilityId = hotelFacilityId;
        this.bookingDate = bookingDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public Long getHotelFacilityId() {
        return hotelFacilityId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public String getNote() {
        return note;
    }

    public String getGuest() {
        return guest;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getPayedBy() {
        return payedBy;
    }

    public String getPayment() {
        return payment;
    }

    public void setTables(final Set tables){
        this.tables = tables;
    }

    public boolean bookedTables(Set<RestaurantTable> tables){
        for(RestaurantTable table: tables) {
            if(this.tables.contains(table)) return true;
        }

        return false;
    }

    public boolean isBookable(final Date fromTime, final Date toTime, final Set<RestaurantTable> tables){
        if(rule.isBookableTime(this.fromTime, this.toTime, fromTime, toTime)){
            return true;
        }else{
            return !bookedTables(tables);
        }
    }

    @Override
    public String toString() {
        return "RestaurantBooking{" +
                "id=" + id +
                ", hotelFacilityId=" + hotelFacilityId +
                ", bookingDate='" + bookingDate + '\'' +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", note='" + note + '\'' +
                '}';
    }
}
