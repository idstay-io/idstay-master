package idstay.facilities.booking.restaurant.support;

import idstay.facilities.booking.restaurant.RestaurantBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
public interface RestaurantBookingRepository extends Repository<RestaurantBooking, Long> {
    List<RestaurantBooking> findByhotelFacilityIdAndBookingDate(Long hotelFacilityId, String bookingDate);
    Optional<RestaurantBooking> findOne(Long bookingId);
    RestaurantBooking save(RestaurantBooking restaurantBooking);
}
