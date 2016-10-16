package idstay.facilities.booking;

import idstay.facilities.booking.support.FacilityBookingParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
public class FacilityReservationService {
    public Long makeReservation(FacilityBookingParam reservationParam) {
        return 1L;
    }

    public void cancelReservation(Long reservationId) { }

    public List<FacilityBooking> getReservations(Date date){ return null; }

    public Optional<FacilityBooking> getReservation(Long reservationId){ return null; }
}
