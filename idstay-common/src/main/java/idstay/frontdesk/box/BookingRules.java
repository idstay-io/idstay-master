package idstay.frontdesk.box;

import idstay.backoffice.config.hotel.Room;
import idstay.frontdesk.booking.StayInfo;
import org.springframework.stereotype.Service;

@Service
public class BookingRules {
    public boolean isValidStay(final Room room, final StayInfo stayInfo){
        return true;
    }

}
