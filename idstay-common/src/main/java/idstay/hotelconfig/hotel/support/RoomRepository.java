package idstay.hotelconfig.hotel.support;

import idstay.hotelconfig.hotel.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
