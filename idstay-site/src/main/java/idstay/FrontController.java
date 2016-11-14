package idstay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 3.
 */
@Controller
public class FrontController {
    private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

    private static final String URL_OTA_INVOICE = "/1/ota_invoice";


    @RequestMapping(value="/", method = {GET})
    public String index() {
        return housekeeping();
    }

    @RequestMapping(value="/housekeeping2", method = {GET})
    public String housekeeping() {
        String unDefinedCrew = "select_crew_name";
        String url = "/hotel/1/housekeepings/" + unDefinedCrew;
        return "redirect:" + url;
    }

    @RequestMapping(value="/checkout", method = {GET})
    public String checkout() {
        logger.info("checkout");
        String url = "/hotel/1/checkouts";
        return "redirect:" + url;
    }

    @RequestMapping(value="/reservation", method = {GET})
    public String reservaton() {
        logger.info("ota_invoice");




        return "redirect:" + URL_OTA_INVOICE;
    }








    @RequestMapping(value="/thecommon", method = {GET})
    public String thecommon() {
        logger.info("thecommon");
        String url = "/hotel/1/facility/1";
        return "redirect:" + url;
    }


}
