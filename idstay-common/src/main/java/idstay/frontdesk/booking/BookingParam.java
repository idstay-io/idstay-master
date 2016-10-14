package idstay.frontdesk.booking;

import idstay.frontdesk.reservation.Reservation;
import idstay.frontdesk.reservation.ReservationChannel;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 9.
 */
public class BookingParam {
    public static BookingParam.Reservation reservationParam() {
        return new BookingParam.Reservation();
    }

    public static class Reservation {
        private StayInfo stayInfo;
        private Long roomId;

        private ReservationChannel reservationChannel;


        public BookingParam.Reservation stayInfo(StayInfo stayInfo) {
            this.stayInfo = stayInfo;
            return this;
        }

        public StayInfo getStayInfo() {
            return stayInfo;
        }

        public BookingParam.Reservation roomId(Long roomId) {
            this.roomId = roomId;
            return this;
        }

        public Long getRoomId() {
            return roomId;
        }

        public BookingParam.Reservation reservationChannnel(ReservationChannel reservationChannel) {
            this.reservationChannel = reservationChannel;
            return this;
        }

        public ReservationChannel getReservationChannel() {
            return reservationChannel;
        }
    }
}
