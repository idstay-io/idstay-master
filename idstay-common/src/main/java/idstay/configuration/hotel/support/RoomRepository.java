package idstay.configuration.hotel.support;

import idstay.configuration.hotel.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
