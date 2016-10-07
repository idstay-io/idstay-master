package idstay.frontdesk.booking;

import idstay.TestConfig;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.reservation.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class ReservationTest {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReservationService reservationService;

    @Test
    public void minsoo() {
        StayInfo stayInfo = new StayInfo("2016.01.01", "2016.01.15", 1, 0);

        Optional<Booking> booking = reservationService.makeReservation(stayInfo, 1L);

        assertThat(booking.isPresent(), is(true));
    }
}
