package idstay.profiles.hotelguest.support;

import idstay.profiles.hotelguest.HotelGuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelGuestRepository extends JpaRepository<HotelGuest, Long>{
    Optional<HotelGuest> findByEmail(String email);
}
