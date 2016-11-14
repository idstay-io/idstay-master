package idstay.frontdesk.booking.request;

import org.apache.commons.lang3.Validate;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 8.
 */
public class StayInfo {
    private int fromDate;
    private int toDate;
    private int adults;
    private int kids;

    public StayInfo() {}
    public StayInfo fromDate(final int fromDate) {
        Validate.notNull(fromDate, "fromDate  is required");
        this.fromDate = fromDate;
        return this;
    }

    public StayInfo toDate(final int toDate) {
        Validate.notNull(toDate, "toDate is required");
        this.toDate = toDate;
        return this;
    }

    public StayInfo adults(final int adults) {
        Validate.notNull(adults, "toDate is required");
        this.adults = adults;
        return this;
    }

    public StayInfo kids(final int kids) {
        Validate.notNull(kids, "toDate is required");
        this.kids = kids;
        return this;
    }

    public int getFromDate() {
        return fromDate;
    }

    public int getToDate() {
        return toDate;
    }

    public int getAdults() {
        return adults;
    }

    public int getKids() {
        return kids;
    }

    @Override
    public String toString() {
        return "StayInfo{" +
                "fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", adults=" + adults +
                ", kids=" + kids +
                '}';
    }
}
