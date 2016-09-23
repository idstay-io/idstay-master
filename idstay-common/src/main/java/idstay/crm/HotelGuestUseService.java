package idstay.crm;

import idstay.crm.support.HotelGuestUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HotelGuestUseService {
    private HotelGuestUseRepository hotelGuestUseRepository;

    public List<HotelGuestUse> getGuestUseByDate(Date date) {
        return hotelGuestUseRepository.findAll();
    }

    @Autowired
    public void setHotelGuestUseRepository(HotelGuestUseRepository hotelGuestUseRepository) {
        this.hotelGuestUseRepository = hotelGuestUseRepository;
    }
}
