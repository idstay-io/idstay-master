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
    private int checkin;
    private int checkout;

    protected StayPeriod() {}

    public StayPeriod(final int checkin, final int checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getCheckout() {
        return checkout;
    }

    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "StayPeriod{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                '}';
    }
}