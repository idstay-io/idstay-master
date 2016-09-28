package idstay.frontdesk.booking;

import idstay.hotelconfig.hotel.Room;
import idstay.frontdesk.booking.support.RoomOccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StayService {
    private RoomOccupancyRepository roomOccupancyRepository;

    public boolean isValidStay(final Room room, final StayInformation stayInformation) {
        return false;
    }

    public List<StayLine> findByDate(Date date) {
        return roomOccupancyRepository.findByDate(date);
    }

    @Autowired
    public void setRoomOccupancyRepository(RoomOccupancyRepository roomOccupancyRepository) {
        this.roomOccupancyRepository = roomOccupancyRepository;
    }
}
