package idstay.facilities.restaurant;

import idstay.facilities.booking.shared.RestaurantTable;
import idstay.facilities.restaurant.dto.BookingForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 3.
 */
@Controller
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping(value="/hotel/{hotelId}/facility/{facilityId}", method = GET)
    public String reservationList(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("facilityId") String facilityId,
            Model model) {
        logger.info("{}, {}", hotelId.toString(), facilityId);
        //model.addAttribute("housekeepings", getHousekeepingDtoList(hotelId));
        return "facilities/restaurant/list";
    }

    @RequestMapping(value="/{hotelId}/facility/{facilityId}/booking", method = GET)
    public String getBookingForm(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("facilityId") String facilityId,
            Model model) {
        logger.info("{}, {}", hotelId.toString(), facilityId);



        model.addAttribute("booking", getBookingForm());
        return "facilities/restaurant/booking";
    }

    @RequestMapping(value="/{hotelId}/facility/{facilityId}/booking", method = POST)
    public String saveBookingForm(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("facilityId") String facilityId,
            @ModelAttribute BookingForm dto,
            BindingResult result,
            Model model) {

        logger.info(dto.toString());

        model.addAttribute("booking", getBookingForm());
        return "facilities/restaurant/booking";
    }





    private BookingForm getBookingForm(){
        BookingForm form = new BookingForm();

        form.setFacilityId(12L);
        form.setBookingDate("2016.01.01");

        return form;
    }


    @ModelAttribute("allTables")
    public List<RestaurantTable> getAllTables() {
        return  Arrays.asList(RestaurantTable.values());
    }


}
