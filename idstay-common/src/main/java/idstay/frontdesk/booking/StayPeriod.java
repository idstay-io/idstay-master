package idstay.frontdesk.booking;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.util.Date;

import idstay.common.util.DateTimeUtil;
import org.apache.commons.lang3.*;

@Embeddable
public class StayPeriod {
    @Temporal(TemporalType.DATE)
    private Date checkin;
    @Temporal(TemporalType.DATE)
    private Date checkout;
    private int nights = 0;

    protected StayPeriod() {
    }

    public StayPeriod(final String checkin, final String checkout) throws ParseException {
        Validate.notNull(checkin, "Check in is required");
        Validate.notNull(checkout, "check out is required");

        this.checkin = DateTimeUtil.parseDate(checkin);
        this.checkout = DateTimeUtil.parseDate(checkout);
    }

    @Override
    public String toString() {
        return "StayPeriod{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                ", nights=" + nights +
                '}';
    }
}