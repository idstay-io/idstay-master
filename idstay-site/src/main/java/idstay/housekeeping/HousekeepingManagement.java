package idstay.housekeeping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HousekeepingManagement {
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingManagement.class);
    private HousekeepingService housekeepingService;

    @RequestMapping(value="/hotel/{hotelId}/housekeepings/reset/@will", method = GET)
    public String resetHousekeeping() {
        logger.info("resetHousekeeping: {}", "by @will");

        housekeepingService.reset(1L);

        String unDefinedCrew = "@will";
        String url = "/hotel/1/housekeepings/" + unDefinedCrew;
        return "redirect:" + url;
    }

    @Autowired
    public void setHousekeepingService(HousekeepingService housekeepingService) {
        this.housekeepingService = housekeepingService;
    }

}
