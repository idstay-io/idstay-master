package idstay.backoffice.config.hotel.support;

import idstay.backoffice.config.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
}