package idstay.guestmanagement;

import idstay.guestmanagement.support.GuestProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestProfileService {
    private GuestProfileRepository guestProfileRepository;

    public Long findGuestProfile(GuestProfile guestProfile) {
        Optional<GuestProfile> guest = guestProfileRepository.findByGuestNameAndEmail(guestProfile.getGuestName(), guestProfile.getEmail());
        if(guest.isPresent())
            return guest.get().getId();

        GuestProfile newProfile = createHotelGuestProfile(guestProfile);
        return newProfile.getId();
    }



    public GuestProfile createHotelGuestProfile(GuestProfile hotelGuestProfile) {
        return guestProfileRepository.save(hotelGuestProfile);
    }

    @Autowired
    public void setHotelGuestProfileRepository(GuestProfileRepository hotelGuestProfileRepository) {
        this.guestProfileRepository = hotelGuestProfileRepository;
    }



}
