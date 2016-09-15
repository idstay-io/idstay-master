package idstay.hotel.support;

import idstay.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
}