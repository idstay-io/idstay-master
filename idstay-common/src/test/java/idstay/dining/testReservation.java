package idstay.dining;

import idstay.backoffice.config.facilities.support.HotelFacilityRepository;
import idstay.facilities.booking.restaurant.RestaurantBookingParam;

import idstay.facilities.booking.restaurant.support.RestaurantBookingRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "unittest")
public class testReservation {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HotelFacilityRepository repository;

    @Autowired
    private RestaurantBookingRepository repository2;

    @Test
    public void cancelReservation() {
        //RestaurantBookingParam param = new RestaurantBookingParam("2016.01.01", "10:30", "11:00");

        //RestaurantBooking booking = new RestaurantBooking(param.getBookingDate(), param.getFromDate(), param.getToDate(), "minsoo");


        //this.entityManager.persist(booking);

        //System.out.println(repository2.findOne(1L));

//        HotelFacility theCommon = repository.save(new HotelFacility("The COMMON"));
//
//        RestaurantBookingParam param = RestaurantBookingParam.param()
//                .facilityId(theCommon.getId())
//                .bookingDate("2016.01.01")
//                .fromTime("15:30")
//                .toTime("16:20")
//                .meme(null);
//
//        RestaurantBooking booking = new RestaurantBooking(param);
//        booking.setFromTime();
//
//        RestaurantBooking booking2 = repository2.save(booking);
//
//        System.out.println(booking2);


//        facilityReservationService.cancelReservation(1L);
    }


//
//
//    FacilityReservationService facilityReservationService = new FacilityReservationService();
//
//    @Test
//    public void makeReservation() {
//        RestaurantBookingParam bookingParam = new RestaurantBookingParam();
//        Long facilityBookingId = facilityReservationService.makeReservation(bookingParam);
//    }
//
//    @Test
//    public void getReservations() {
//        List<RestaurantBooking> bookings = facilityReservationService.getReservations(new Date());
//
//        Optional<RestaurantBooking> booking = facilityReservationService.getReservation(1L);
//
//    }
//
//    @Test
//    public void cancelReservation() {
//        facilityReservationService.cancelReservation(1L);
//    }




}







