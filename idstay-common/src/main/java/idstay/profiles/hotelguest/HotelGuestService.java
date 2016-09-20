package idstay.profiles.hotelguest;

import idstay.profiles.customer.CustomerService;
import idstay.profiles.hotelguest.support.HotelGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelGuestService {
    private CustomerService customerService;
    private HotelGuestRepository hotelGuestRepository;

    public HotelGuest getBookingGuest(HotelGuest hotelGuest) {
        if (hotelGuest.identifiable()) {
            Optional<HotelGuest> guest = findByEmail(hotelGuest.getEmail());
            if(guest.isPresent()) return guest.get();
        }

        return createHotelGuest(hotelGuest);
    }

    public Optional<HotelGuest> findByEmail(final String email) {
        return hotelGuestRepository.findByEmail(email);
    }

    public HotelGuest createHotelGuest(HotelGuest hotelGuest) {
        return hotelGuestRepository.save(hotelGuest);
    }

    @Autowired
    public void setCustomerService(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setHotelGuestRepository(HotelGuestRepository hotelGuestRepository) {
        this.hotelGuestRepository = hotelGuestRepository;
    }


}
