package idstay.frontdesk.booking;

import idstay.configuration.hotel.Room;
import idstay.frontdesk.booking.support.RoomOccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomOccupancyService {
    private RoomOccupancyRepository roomOccupancyRepository;

    public boolean isValidStay(final Room room, final StayInformation stayInformation) {
        return false;
    }


    @Autowired
    public void setRoomOccupancyRepository(RoomOccupancyRepository roomOccupancyRepository) {
        this.roomOccupancyRepository = roomOccupancyRepository;
    }
}
