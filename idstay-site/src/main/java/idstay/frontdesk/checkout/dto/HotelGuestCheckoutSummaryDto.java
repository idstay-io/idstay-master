package idstay.frontdesk.checkout.dto;

import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 2.
 */
public class HotelGuestCheckoutSummaryDto {
    private String roomName;
    private String fromDate;
    private String toDate;
    private String guestName;
    private int totalAmount;
    private List<String> detail;

    public String getRoomName() {
        return roomName;
    }

    public HotelGuestCheckoutSummaryDto setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getFromDate() {
        return fromDate;
    }

    public HotelGuestCheckoutSummaryDto setFromDate(String fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public String getToDate() {
        return toDate;
    }


    public String getGuestName() {
        return guestName;
    }

    public HotelGuestCheckoutSummaryDto setGuestName(String guestName) {
        this.guestName = guestName;
        return this;
    }

    public HotelGuestCheckoutSummaryDto setToDate(String toDate) {
        this.toDate = toDate;
        return this;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public HotelGuestCheckoutSummaryDto setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public List<String> getDetail() {
        return detail;
    }

    public HotelGuestCheckoutSummaryDto setDetail(List<String> detail) {
        this.detail = detail;
        return this;
    }
}
