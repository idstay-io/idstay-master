package idstay.frontdesk.booking;

import org.springframework.stereotype.Service;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
@Service
public class RoomAvailabilityService {
    public boolean availableRoom(StayPeriod period, Long roomId) {
        return true;
    }
}
