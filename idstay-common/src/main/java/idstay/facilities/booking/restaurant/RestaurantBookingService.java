package idstay.facilities.booking.restaurant;

import idstay.facilities.booking.shared.FacilityBookingException;
import idstay.facilities.booking.restaurant.support.RestaurantBookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 16.
 */
@Service
public class RestaurantBookingService {
    private static final Logger logger = LoggerFactory.getLogger(RestaurantBookingService.class);

    private RestaurantBookingRepository facilityBookingRepository;

    public List<RestaurantBooking> getBookingList(final Long hotelFacilityId, final String bookingDate){
        return facilityBookingRepository.findByhotelFacilityIdAndBookingDate(hotelFacilityId, bookingDate);
    }

    public Optional<RestaurantBooking> getBooking(final Long bookingId){
        return facilityBookingRepository.findOne(bookingId);
    }

    public RestaurantBooking makeBooking(final RestaurantBookingParam param){
        if(verifyBookable(param)){
            return facilityBookingRepository.save(param.toBooking());
        }else{
            logger.info("FacilityBookingException: {}", param.toString());
            throw new FacilityBookingException(param.toString());
        }
    }

    private boolean verifyBookable(final RestaurantBookingParam param){
        List<RestaurantBooking> bookingList = facilityBookingRepository.findByhotelFacilityIdAndBookingDate(
                param.getHotelFacilityId(),
                param.getBookingDate());

        for(RestaurantBooking booking : bookingList) {
            if(!booking.isBookable(param.getFromDate(), param.getToDate(), param.getTables()))
                return false;
        }
        return true;
    }






//
//    public Long makeReservation() {
//        return 1L;
//    }
//
//    public void cancelReservation(Long reservationId) { }
//
//    public List<RestaurantBooking> getReservations(Date date){ return null; }
//
//    public Optional<RestaurantBooking> getReservation(Long reservationId){ return null; }

    @Autowired
    public void setFacilityBookingRepository(RestaurantBookingRepository restaurantBookingRepository){
        this.facilityBookingRepository = restaurantBookingRepository;
    }

}
