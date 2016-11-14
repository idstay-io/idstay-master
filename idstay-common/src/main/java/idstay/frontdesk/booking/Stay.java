package idstay.frontdesk.booking;

import idstay.frontdesk.booking.id.StayId;
import idstay.frontdesk.booking.request.StayInfo;
import idstay.frontdesk.booking.support.InValidBookingException;
import org.apache.commons.lang3.Validate;
import org.springframework.core.annotation.Order;
import org.springframework.expression.ParseException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */

@Entity
@Table(name="stay")
public class Stay {
    @EmbeddedId
    private StayId stayId;

    private Long roomId;

    @Embedded
    private StayPeriod stayPeriod;
    private int adults;
    private int kids;
    private String guestName;

    @OneToOne(mappedBy = "stay")
    private Booking booking;

    protected Stay() {}
    public Stay(final StayId stayId, final Long roomId, final int checkin, final int checkout, final int adults, final int kids, final String guestName) throws ParseException, InValidBookingException, java.text.ParseException {
        Validate.notNull(stayId, "stayId  is required");
        Validate.notNull(roomId, "roomId  is required");
        Validate.notNull(checkin, "checkin  is required");
        Validate.notNull(checkout, "checkout is required");
        Validate.notNull(adults, "adults in is required");
        Validate.notNull(kids, "kids in is required");
        Validate.notNull(guestName, "guestName in is required");

        this.stayId = stayId;
        this.roomId = roomId;
        this.stayPeriod = new StayPeriod(checkin, checkout);
        this.adults = adults;
        this.kids = kids;
        this.guestName = guestName;
    }

    public StayId getStayId() {
        return stayId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public StayPeriod getStayPeriod() {
        return stayPeriod;
    }

    public int getAdults() {
        return adults;
    }

    public int getKids() {
        return kids;
    }

    public String getGuestName() {
        return guestName;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "Stay{" +
                "id=" + stayId +
                ", roomId=" + roomId +
                ", stayPeriod=" + stayPeriod +
                ", adults=" + adults +
                ", kids=" + kids +
                ", guestName='" + guestName + '\'' +
                ", booking=" + booking +
                '}';
    }

    public static Stay fromRequest(String s, StayInfo stayInfo) {

    }
}