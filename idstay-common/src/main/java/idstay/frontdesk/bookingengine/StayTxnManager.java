package idstay.frontdesk.bookingengine;

import idstay.frontdesk.booking.Booking;
import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.id.StayId;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.booking.support.InValidBookingException;
import idstay.frontdesk.booking.support.StayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
@Component
public class StayTxnManager {
    private static final Logger logger = LoggerFactory.getLogger(StayTxnManager.class);
    private StayRepository stayRepository;
    private BookingRule bookingRule;

    @Transactional
    public Optional<StayId> save(final Stay stay) throws InValidBookingException {
        if (isAvaiableStay(stay)) {
            StayId stayId = StayId.newId();
            stayRepository.save(stay);
            return Optional.of(stayId);
        }
        return Optional.empty();
    }

    private boolean isAvaiableStay(final Stay stay) throws InValidBookingException {
        List<Stay> stays = stayRepository.findRegisteredStay(stay.getRoomId(), stay.getStayPeriod().getCheckin(), stay.getStayPeriod().getCheckout());

        for(Stay bookedStay: stays) {
            if(! bookingRule.isValid(bookedStay, stay)) {
                throw new InValidBookingException(bookedStay.toString());
            }
        }



        return true;
    }

    @Autowired
    public void setStayRepository(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }

    @Autowired
    public void setBookingRule(BookingRule bookingRule) {
        this.bookingRule = bookingRule;
    }

}
