package idstay.configuration.hotel.support;

import idstay.configuration.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
}