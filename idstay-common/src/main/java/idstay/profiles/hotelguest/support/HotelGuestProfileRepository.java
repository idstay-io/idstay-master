package idstay.profiles.hotelguest.support;

import idstay.profiles.hotelguest.HotelGuestProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public interface HotelGuestProfileRepository extends JpaRepository<HotelGuestProfile, Long>{
    Optional<HotelGuestProfile> findByEmail(String email);
}
