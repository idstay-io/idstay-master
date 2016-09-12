package idstay.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idstay.hotel.support.HotelRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

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
