package idstay.hotel;

import idstay.hotel.support.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    public Hotel findByHotelId(Long hotelId) {
        return hotelRepository.findOne(hotelId);
    }

    @Autowired
    public void setHotelRepository(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
}
