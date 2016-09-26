package idstay.frontdesk.booking;

import idstay.frontdesk.booking.support.StayRepository;
import idstay.frontdesk.common.BookingChannel;
import idstay.profiles.hotelguest.HotelGuestProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 26.
 */
@Service
public class StayService {
    private StayRepository stayRepository;


    public Optional<Stay> registerStayInfo(final StayPeriod period, final HotelGuestProfile profile) {
        Stay stay = new Stay(period);
        stay.setHotelGuestProfile(profile);

        return Optional.of(stayRepository.save(stay));
    }



    @Autowired
    public void setStayRepository(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }
}
