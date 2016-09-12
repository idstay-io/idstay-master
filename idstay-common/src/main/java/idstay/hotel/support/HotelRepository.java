package idstay.hotel.support;

import org.springframework.data.repository.CrudRepository;

import idstay.hotel.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
}