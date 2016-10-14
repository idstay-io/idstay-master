package idstay.frontdesk.reservation;

import idstay.common.util.infra.EntityIdUtil;
import idstay.common.util.infra.EntityName;
import idstay.frontdesk.booking.*;
import idstay.frontdesk.reservation.support.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */
@Service
public class ReservationService {
    private EntityIdUtil entityIdUtil;
    private ReservationRepository reservationRepository;
    private RoomAvailabilityService roomAvailabilityService;

    public BookingId bookNewReservation(BookingParam.Reservation bookingParam) {
        BookingId bookingId = getBookingId();
        Reservation reservation = new Reservation(bookingId, bookingParam.getStayInfo(), bookingParam.getRoomId(), "hahahah");
        reservation.reservationChannel(bookingParam.getReservationChannel());
        reservationRepository.save(reservation).getBookingId();
        return reservation.getBookingId();
    }

//    public Optional<Booking> makeReservation(List<Stay> stays) {
//        Booking booking = Booking.newInstance();
//
//        for(Stay stay : stays) {
//            booking.withStay(stay);
//        }
//
//
//        return Optional.of(reservationRepository.save(booking));
//    }


    private BookingId getBookingId() {
        String id = entityIdUtil.getID(EntityName.BOOKING);
        return new BookingId(id);
    }



    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Autowired
    public void setRoomAvailabilityService(RoomAvailabilityService roomAvailabilityService) {
        this.roomAvailabilityService = roomAvailabilityService;
    }

    @Autowired
    public void setEntitySequencesUtil(EntityIdUtil entityIdUtil) {
        this.entityIdUtil = entityIdUtil;
    }

}
