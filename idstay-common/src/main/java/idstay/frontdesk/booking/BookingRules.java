package idstay.frontdesk.booking;

import idstay.configuration.hotel.Room;
import org.springframework.stereotype.Service;

@Service
public class BookingRules {
    public boolean isValidStay(final Room room, final StayInformation stayInformation){
        return true;
    }

}
