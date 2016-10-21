package idstay.facilities.restaurant.dto;

import idstay.facilities.booking.shared.RestaurantTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 21.
 */
public class BookingForm {
    private Long hotelId;
    private Long facilityId;
    private String bookingDate;
    private String fromHour;
    private String fromMinutes;
    private String toHour;
    private String toMinutes;

    private String guestName;
    private String roomNumber;
    private String contact;

    private boolean stage;
    private String stageNote;


    private String takeout;
    private String note;

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    private String deposit;

    private String crew;
    private String bookingTime;


    private List<RestaurantTable> tables = new ArrayList<RestaurantTable>();

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(String fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public String getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(String toMinutes) {
        this.toMinutes = toMinutes;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isStage() {
        return stage;
    }

    public void setStage(boolean stage) {
        this.stage = stage;
    }

    public String getStageNote() {
        return stageNote;
    }

    public void setStageNote(String stageNote) {
        this.stageNote = stageNote;
    }

    public String getTakeout() {
        return takeout;
    }

    public void setTakeout(String takeout) {
        this.takeout = takeout;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public List<RestaurantTable> getTables() {
        return tables;
    }

    public void setTables(List<RestaurantTable> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "hotelId=" + hotelId +
                ", facilityId=" + facilityId +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
