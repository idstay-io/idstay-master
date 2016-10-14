package idstay.frontdesk.box;

import idstay.frontdesk.reservation.ReservationChannel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class BookingChannelInformation {



    private String ota;

    private String otaCardNo;
    private long otaTotalAmount;
    private String otaReservationId;
    private String otaDailyRate;
    private String memo;

    public BookingChannelInformation() {}

}
