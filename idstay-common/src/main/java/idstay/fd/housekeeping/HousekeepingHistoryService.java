package idstay.fd.housekeeping;

import idstay.fd.housekeeping.support.HousekeepingHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HousekeepingHistoryService {
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingHistoryService.class);

    private HousekeepingHistoryRepository housekeepingHistoryRepository;

    @Transactional(readOnly = true)
    public HousekeepingHistory save(HousekeepingHistory housekeepingHistory) {
        logger.info("housekeepingHistory save: {}, {}", housekeepingHistory.toString());
        return housekeepingHistoryRepository.save(housekeepingHistory);
    }

    @Transactional(readOnly = true)
    public Optional<List<HousekeepingHistory>> findHistory(Date fromDate, Date toDate) {
//        Calendar toDateCal = Calendar.getInstance();
//        toDateCal.setTime(new Date());
//        toDateCal.add(Calendar.DATE, -1);
//        System.out.println(new Date());
//        System.out.println(toDateCal.getTime());
        return housekeepingHistoryRepository.findHistory(fromDate, toDate);
    }

    @Autowired
    public void setHousekeepingHistoryService(HousekeepingHistoryRepository housekeepingHistoryRepository) {
        this.housekeepingHistoryRepository = housekeepingHistoryRepository;
    }

}
