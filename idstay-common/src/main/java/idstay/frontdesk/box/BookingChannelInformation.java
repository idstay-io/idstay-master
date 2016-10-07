package idstay.frontdesk.box;

import idstay.frontdesk.common.BookingChannel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class BookingChannelInformation {

    @Column(name="booking_channel")
    @Enumerated(EnumType.STRING)
    private BookingChannel bookingChannel;

    private String ota;

    private String otaCardNo;
    private long otaTotalAmount;
    private String otaReservationId;
    private String otaDailyRate;
    private String memo;

    public BookingChannelInformation() {}

}
