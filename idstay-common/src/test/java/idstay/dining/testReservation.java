package idstay.dining;

import idstay.backoffice.config.facilities.HotelFacility;
import idstay.backoffice.config.facilities.support.HotelFacilityRepository;
import idstay.facilities.booking.FacilityBooking;
import idstay.facilities.booking.FacilityReservationService;
import idstay.facilities.booking.support.FacilityBookingParam;
import idstay.facilities.booking.support.FacilityBookingRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
import idstay.TestConfig;
import idstay.backoffice.config.crew.Crew;
import idstay.backoffice.config.crew.CrewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles(profiles = "unittest")
public class testReservation {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HotelFacilityRepository repository;

    @Autowired
    private FacilityBookingRepository repository2;

    @Test
    public void cancelReservation() {
        HotelFacility theCommon = repository.save(new HotelFacility("The COMMON"));

        FacilityBookingParam param = FacilityBookingParam.param()
                .facilityId(theCommon.getId())
                .bookingDate("2016.01.01")
                .fromTime("15:30")
                .toTime("16:20")
                .meme(null);

        FacilityBooking booking = new FacilityBooking(param);

        repository2.save(booking);



//        facilityReservationService.cancelReservation(1L);
    }


//
//
//    FacilityReservationService facilityReservationService = new FacilityReservationService();
//
//    @Test
//    public void makeReservation() {
//        FacilityBookingParam bookingParam = new FacilityBookingParam();
//        Long facilityBookingId = facilityReservationService.makeReservation(bookingParam);
//    }
//
//    @Test
//    public void getReservations() {
//        List<FacilityBooking> bookings = facilityReservationService.getReservations(new Date());
//
//        Optional<FacilityBooking> booking = facilityReservationService.getReservation(1L);
//
//    }
//
//    @Test
//    public void cancelReservation() {
//        facilityReservationService.cancelReservation(1L);
//    }




}







