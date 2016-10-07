package idstay.profiles.hotelguest;

import idstay.profiles.hotelguest.support.HotelGuestProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelGuestProfileService {
    private HotelGuestProfileRepository hotelGuestProfileRepository;

    public HotelGuestProfile getBookingGuest(HotelGuestProfile hotelGuestProfile) {
        Optional<HotelGuestProfile> guest = findByEmail(hotelGuestProfile.getEmail());
        if(guest.isPresent())
            return guest.get();

        return createHotelGuestProfile(hotelGuestProfile);
    }

    public Optional<HotelGuestProfile> findByEmail(final String email) {
        return hotelGuestProfileRepository.findByEmail(email);
    }

    public HotelGuestProfile createHotelGuestProfile(HotelGuestProfile hotelGuestProfile) {
        return hotelGuestProfileRepository.save(hotelGuestProfile);
    }

    @Autowired
    public void setHotelGuestProfileRepository(HotelGuestProfileRepository hotelGuestProfileRepository) {
        this.hotelGuestProfileRepository = hotelGuestProfileRepository;
    }


}
