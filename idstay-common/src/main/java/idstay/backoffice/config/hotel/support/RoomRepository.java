package idstay.backoffice.config.hotel.support;

import idstay.backoffice.config.hotel.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
