package idstay.guestmanagement.support;

import idstay.guestmanagement.GuestProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public interface GuestProfileRepository extends JpaRepository<GuestProfile, Long>{
    Optional<GuestProfile> findByGuestNameAndEmail(String guestName, String email);
}
