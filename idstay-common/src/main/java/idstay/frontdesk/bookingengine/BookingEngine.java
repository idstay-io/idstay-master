package idstay.frontdesk.bookingengine;

import idstay.frontdesk.booking.Booking;

import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.request.BookingRequest;
import idstay.frontdesk.booking.request.GuestInfo;
import idstay.frontdesk.booking.id.StayId;
import idstay.frontdesk.booking.support.InValidBookingException;
import idstay.guestmanagement.GuestProfile;
import idstay.guestmanagement.GuestProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */
@Service
public class BookingEngine {
    private static final Logger logger = LoggerFactory.getLogger(BookingEngine.class);
    private StayTxnManager stayTxnManager;
    private GuestProfileService guestProfileService;

    @Transactional
    public Booking makeNewReservation(final BookingRequest request) {
        Stay stay = Stay.fromRequest("", request.getStayInfo());



        try {
            Optional<StayId> stayId = stayTxnManager.save(booking.getStay());


        } catch (InValidBookingException e) {

        }


        if(booking.getGuestInfo().isIdentifiable()) {
            GuestProfile profile = toGuestProfile(booking.getGuestInfo());
            Long guestProfileId = guestProfileService.findGuestProfile(profile);
        }

        logger.info("makeNewReservation" + booking.toString());

        return null;
    }

    private GuestProfile toGuestProfile(final GuestInfo guestInfo) {
        GuestProfile profile = new GuestProfile(guestInfo.getEmail(), guestInfo.getGuestName());
        return profile;
    }




    @Autowired
    public void setBookingTxnManager(StayTxnManager stayTxnManager) {
        this.stayTxnManager = stayTxnManager;
    }

    @Autowired
    public void setGuestProfileService(GuestProfileService guestProfileService) {
        this.guestProfileService = guestProfileService;
    }

}
