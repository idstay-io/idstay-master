package idstay.frontdesk.booking;

import idstay.TestConfig;
import idstay.common.util.infra.EntityName;
import idstay.common.util.infra.EntitySequences;
import idstay.common.util.infra.EntitySequencesRepository;
import idstay.common.util.infra.EntityIdUtil;
import idstay.frontdesk.reservation.ReservationChannel;
import idstay.frontdesk.reservation.support.ReservationRepository;
import idstay.frontdesk.reservation.Reservation;
import idstay.frontdesk.reservation.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class ReservationTest {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EntityIdUtil sequencesUtil;

    @Autowired
    private EntitySequencesRepository entitySequencesRepository;

    @Test
    public void minsoo() {
        entitySequencesRepository.save(new EntitySequences(EntityName.BOOKING, 0L));

        StayInfo stayInfo = new StayInfo("2016.01.01", "2016.01.15", 1, 0);
        Long roomId = 1L;

        BookingParam.Reservation bookingParam= BookingParam.reservationParam()
                .stayInfo(stayInfo)
                .roomId(roomId)
                .reservationChannnel(ReservationChannel.OTA);

        BookingId bookingId = reservationService.bookNewReservation(bookingParam);

        Reservation reservation = reservationRepository.findOne(bookingId);

        assertThat(reservation.getBookingType(), is(BookingType.RESERVATION));
        System.out.println(reservation);

    }

    @Test
    public void idGeneratorTest() {
//        EntitySequences sequences = new EntitySequences(EntityName.BOOKING, 0L);
//        entitySequencesRepository.save(sequences);
//
//        assertThat(sequencesUtil.getID(EntityName.BOOKING), is("BK-16282-10"));
//        assertThat(sequencesUtil.getID(EntityName.BOOKING), is("BK-16282-15"));
//        assertThat(sequencesUtil.getID(EntityName.BOOKING), is("BK-16282-15"));
    }
}
