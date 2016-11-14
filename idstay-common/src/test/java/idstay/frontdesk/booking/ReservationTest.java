package idstay.frontdesk.booking;

import idstay.TestConfig;
import idstay.common.util.infra.EntitySequencesRepository;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.bookingengine.BookingEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles(profiles = "unittest")
public class ReservationTest {
    @Autowired
    private BookingRepository reservationRepository;

    @Autowired
    private BookingEngine reservationService;

    @Autowired
    private EntitySequencesRepository entitySequencesRepository;

    @Test
    public void minsoo() {
//        entitySequencesRepository.save(new EntitySequences(EntityName.BOOKING, 0L));
//
//        StayInfo stayInfo = new StayInfo("2016.01.01", "2016.01.15", 1, 0);
//        Long roomId = 1L;
//
//        BookingRequest.Reservation bookingParam= BookingRequest.reservationParam()
//                .stayInfo(stayInfo)
//                .roomId(roomId)
//                .reservationChannnel(ReservationChannel.OTA);
//
//        BookingId bookingId = reservationService.bookNewReservation(bookingParam);
//
//        Reservation reservation = reservationRepository.findOne(bookingId);
//
//        assertThat(reservation.getBookingType(), is(BookingType.RESERVATION));
//        System.out.println(reservation);

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
