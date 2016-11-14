package idstay.housekeeping;

import idstay.common.util.DateTimeUtil;
import idstay.housekeeping.shared.CleaningStatus;
import idstay.housekeeping.shared.Remarks;
import idstay.housekeeping.shared.ReservationStatus;
import idstay.housekeeping.shared.RoomStatus;
import idstay.housekeeping.dto.HousekeepingDto;
import idstay.housekeeping.support.HousekeepingNotFoundException;
import idstay.backoffice.config.crew.Crew;
import idstay.backoffice.config.crew.CrewService;
import idstay.backoffice.config.crew.CrewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HousekeepingController {
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingController.class);

    private static String TEMPLATE_HOUSEKEEPING_LIST = "housekeeping/list";
    private static String TEMPLATE_HOUSEKEEPING_EDIT = "housekeeping/edit";

    private HousekeepingService housekeepingService;
    private CrewService crewService;


    @RequestMapping(value="/hotel/{hotelId}/housekeepings/{crew}", method = GET)
    public String getHousekeepings(@PathVariable("hotelId") Long hotelId,
                                   @PathVariable("crew") String crewName,
                                   Model model) {

        model.addAttribute("crew", crewName);
        model.addAttribute("housekeepings", getHousekeepingDtoList(hotelId));
        return TEMPLATE_HOUSEKEEPING_LIST;
    }

    @RequestMapping(value="/hotel/{hotelId}/housekeeping/{housekeepingId}/{crew}", method = GET)
    public String editHousekeeping(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("housekeepingId") Long housekeepingId,
            @PathVariable("crew") String crewName,
            Model model) {

        logger.info("editHousekeeping: {}, {}",  housekeepingId.toString(), crewName);

        model.addAttribute("crew", crewName);
        model.addAttribute("housekeeping", getHousekeepingDto(housekeepingId));
        return TEMPLATE_HOUSEKEEPING_EDIT;
    }



    private List<HousekeepingDto> getHousekeepingDtoList(Long hotelId) {
        return HousekeepingDto.toList(getHousekeepings(hotelId));
    }

    private List<Housekeeping> getHousekeepings(Long hotelId) {
        List<Housekeeping> housekeepings = housekeepingService.findByHotelId(1L);
        if(housekeepings == null || housekeepings.isEmpty()) {
            logger.error("housekeeping find by hotelId Error: {}", hotelId);
            throw new HousekeepingNotFoundException("housekeeping find by hotelId Error: " + hotelId);
        }

        return housekeepings;
    }





    @RequestMapping(value="/hotel/{hotelId}/housekeeping/{housekeepingId}/{crew}", method = POST)
    public String saveHousekeeping(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("housekeepingId") Long housekeepingId,
            @ModelAttribute HousekeepingDto dto,
            @PathVariable("crew") String crewName,
            BindingResult result,
            Model model) {

        logger.info("saveHousekeeping: {}, {}",  dto.toString(), crewName);
        housekeepingService.save(toHousekeeping(dto), getCrew(crewName));
        String url = "/hotel/1/housekeepings/" + crewName;
        return "redirect:" + url;
    }



    private Housekeeping toHousekeeping(final HousekeepingDto dto) {
        Housekeeping housekeeping = housekeepingService.findById(dto.getHousekeepingId());

        if(housekeeping == null) {
            logger.error("housekeeping find by hotelId Error: {}", dto.getHousekeepingId());
            throw new HousekeepingNotFoundException("housekeeping find by hotelId Error: " + dto.getHousekeepingId());
        }

        return housekeeping
                .reservationStatus(dto.getReservationStatus())
                .roomStatus(dto.getRoomStatus())
                .cleaningStatus(dto.getCleaningStatus())
                .remarks(dto.getRemarks())
                .memo(dto.getMemo());
    }

    private HousekeepingDto getHousekeepingDto(Long housekeepingId) {
        return HousekeepingDto.toDto(getHousekeeping(housekeepingId));
    }

    private Housekeeping getHousekeeping(Long housekeepingId) {
        Housekeeping housekeeping = housekeepingService.findById(housekeepingId);
        if(housekeeping == null) {
            logger.error("housekeeping find by housekeepingId Error: {}", housekeepingId);
            throw new HousekeepingNotFoundException("housekeeping find by housekeepingId Error: " + housekeepingId);
        }
        return housekeeping;
    }


    private Crew getCrew(String crewName) {
        return crewService.findByCrewName(crewName);
    }


    @ModelAttribute("allReservationStatus")
    public List<ReservationStatus> getAllReservationStatus() {
        return Arrays.asList(ReservationStatus.values());
    }

    @ModelAttribute("allRoomStatus")
    public List<RoomStatus> getAllRoomStatus() {
        return Arrays.asList(RoomStatus.values());
    }

    @ModelAttribute("allCleaningStatus")
    public List<CleaningStatus> getAllCleaningStatus() {
        return  Arrays.asList(CleaningStatus.values());
    }

    @ModelAttribute("allRemarks")
    public List<Remarks> getAllHousekeepingRemarks() {
        return  Arrays.asList(Remarks.values());
    }

    @ModelAttribute("allCrews")
    public List<CrewDto> getAllCrews() {
        return  CrewDto.dtoList(crewService.getAllCrews());
    }

    @ModelAttribute("curDate")
    public String getCurrentDate() {
        return  DateTimeUtil.getLocalDateString();
    }

    @Autowired
    public void setHousekeepingService(HousekeepingService housekeepingService) {
        this.housekeepingService = housekeepingService;
    }

    @Autowired
    public void setCrewService(CrewService crewService) {
        this.crewService = crewService;
    }
}
