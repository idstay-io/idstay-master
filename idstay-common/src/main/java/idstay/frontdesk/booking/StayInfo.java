package idstay.frontdesk.booking;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.text.ParseException;

@Embeddable
public class StayInfo {

    @Embedded
    private StayPeriod stayPeriod;
    private int adults;
    private int children;

    protected StayInfo() {}
    public StayInfo(final String fromDate, final String toDate, final int adults, final int children) {
        Validate.notNull(fromDate, "fromDate  is required");
        Validate.notNull(toDate, "toDate is required");
        Validate.notNull(adults, "adults in is required");
        Validate.notNull(children, "children in is required");

        try {
            stayPeriod = new StayPeriod(fromDate, toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.adults = adults;
        this.children = children;
    }

    public StayPeriod getStayPeriod() {
        return stayPeriod;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }
}
