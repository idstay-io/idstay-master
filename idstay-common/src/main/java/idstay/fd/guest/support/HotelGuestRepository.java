package idstay.fd.guest.support;

import idstay.fd.guest.HotelGuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelGuestRepository extends JpaRepository<HotelGuest, Long>{
    Optional<HotelGuest> findByEmail(String email);
}
