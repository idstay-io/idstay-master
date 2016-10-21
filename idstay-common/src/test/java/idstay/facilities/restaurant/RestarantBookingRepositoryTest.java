package idstay.facilities.restaurant;

import idstay.facilities.booking.restaurant.RestaurantBooking;
import idstay.facilities.booking.restaurant.support.RestaurantBookingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 21.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("development")
public class RestarantBookingRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RestaurantBookingRepository repository;

    @Test
    public void testExample() throws Exception {
        RestaurantBooking reservation = new RestaurantBooking(1L, "2016.01.01", new Date(), new Date(), "minsoo");
        this.entityManager.persist(reservation);

        assertThat(repository.findByhotelFacilityIdAndBookingDate(1L,"2016.01.01").size(),is(1));
    }


}
