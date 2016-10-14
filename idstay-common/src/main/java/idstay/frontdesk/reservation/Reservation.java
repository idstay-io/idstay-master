package idstay.frontdesk.reservation;

import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.BookingId;
import idstay.frontdesk.booking.BookingType;
import idstay.frontdesk.booking.StayInfo;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */

@Entity
@DiscriminatorColumn
@DiscriminatorValue(value= BookingType.Values.RESERVATION)
public class Reservation extends Booking{
    private String foo;

    protected Reservation() {}
    public Reservation(final BookingId bookingId, final StayInfo stayInfo, final Long roomId, final String foo) {
        super(bookingId, stayInfo, roomId);
        this.foo = foo;
    }

    @Enumerated(EnumType.STRING)
    private ReservationChannel reservationChannel;

    public Reservation reservationChannel(ReservationChannel reservationChannel) {
        this.reservationChannel = reservationChannel;
        return this;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "Booking='" + super.toString() + '\'' +
                ", reservationChannel=" + reservationChannel +
                '}';
    }
}
