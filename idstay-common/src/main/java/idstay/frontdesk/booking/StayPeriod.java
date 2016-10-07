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
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date toDate;

    protected StayPeriod() {
    }

    public StayPeriod(final String fromDate, final String toDate) throws ParseException {
        Validate.notNull(fromDate, "fromDate in is required");
        Validate.notNull(toDate, "toDate out is required");

        this.fromDate = DateTimeUtil.parseDate(fromDate);
        this.toDate = DateTimeUtil.parseDate(toDate);
    }

    @Override
    public String toString() {
        return "StayPeriod{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}