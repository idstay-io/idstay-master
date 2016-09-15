package idstay.frontdesk.booking;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.text.ParseException;

@Embeddable
public class StayInformation {

    @Embedded
    private StayPeriod stayPeriod;
    private int adults;
    private int children;

    protected StayInformation() {}
    public StayInformation(final String checkin, final String checkout, final int adults, final int children) {
        Validate.notNull(checkin, "check in is required");
        Validate.notNull(checkout, "check out is required");
        Validate.notNull(adults, "adults in is required");
        Validate.notNull(children, "children in is required");
//
//        try {
//            this.stayPeriod = new StayPeriod(checkin, checkout);
//        } catch (ParseException e) {
//            //TODO ... 구현 필요함.
//        }
//
//        this.adults = adults;
//        this.children = children;
    }

    public StayPeriod getStayPeriod() {
        return stayPeriod;
    }

}
