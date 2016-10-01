package idstay.frontdesk.checkout;

import idstay.housekeeping.HousekeepingManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class CheckoutController {
    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @RequestMapping(value="/checkout", method = GET)
    public String checkout() {

        logger.info("checkout: {}", "by @will");
        return "/frontdesk/purchase_history";
    }
}
