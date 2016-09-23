package idstay.housekeeping;

import idstay.common.util.DateTimeUtil;
import idstay.housekeeping.common.CleaningStatus;
import idstay.housekeeping.common.ReservationStatus;
import idstay.housekeeping.common.RoomStatus;
import idstay.housekeeping.support.HousekeepingRepository;
import idstay.hotelconfig.hotel.HotelService;
import idstay.hotelconfig.crew.Crew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HousekeepingService {
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingService.class);

    private HousekeepingRepository housekeepingRepository;
    private HousekeepingHistoryService housekeepingHistoryService;
    private HotelService hotelService;

    @Transactional(readOnly=true)
    public List<Housekeeping> findByHotelId(Long hotelId) {
        logger.info("findByHotelId: {}", hotelId);
        return housekeepingRepository.findByHotelId(hotelId);
    }

    @Transactional(readOnly=true)
    public Housekeeping findById(long housekeepingId) {
        Housekeeping housekeeping = housekeepingRepository.findOne(housekeepingId);
        if(housekeeping == null) throw new RuntimeException("housekeeping find Error: " + housekeepingId);
        return housekeeping;
    }

    @Transactional
    public Housekeeping save(Housekeeping housekeeping, Crew crew) {
        logger.info("housekeeping save: {}, {}", housekeeping.toString(), crew.toString());
        housekeeping.lastUpdate(DateTimeUtil.getLocalDate());
        HousekeepingHistory history = HousekeepingHistory.build(housekeeping, crew);
        housekeepingHistoryService.save(history);
        return housekeepingRepository.save(housekeeping);
    }

    @Transactional
    public void reset(Long hotelId) {
        logger.info("housekeeping reset");
        List<Housekeeping> list = findByHotelId(hotelId);

        for(Housekeeping housekeeping : list) {
            housekeeping
                    .reservationStatus(ReservationStatus.NA)
                    .roomStatus(RoomStatus.Vacant)
                    .cleaningStatus(CleaningStatus.NA);
        }

        HousekeepingHistory history = new HousekeepingHistory(0, 0);
        history.setRoomStatus("reset");
    }


    @Autowired
    public void setHousekeepingRepository(HousekeepingRepository housekeepingRepository){
        this.housekeepingRepository= housekeepingRepository;
    }

    @Autowired
    public void setHistoryService(HousekeepingHistoryService housekeepingHistoryService) {
        this.housekeepingHistoryService = housekeepingHistoryService;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }


}