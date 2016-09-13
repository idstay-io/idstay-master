package idstay.fd.housekeeping;

import idstay.common.util.DateTimeUtil;
import idstay.fd.housekeeping.dto.HousekeepingDto;
import idstay.fd.housekeeping.common.CleaningStatus;
import idstay.fd.housekeeping.common.Remarks;
import idstay.fd.housekeeping.common.ReservationStatus;
import idstay.fd.housekeeping.common.RoomStatus;

import idstay.fd.housekeeping.support.HousekeepingNotFoundException;
import idstay.hotel.member.Crew;
import idstay.hotel.member.CrewService;
import idstay.hotel.member.dto.CrewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HousekeepingController {
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingController.class);
    private HousekeepingService housekeepingService;
    private CrewService crewService;

    @RequestMapping(value="/housekeeping", method = {GET})
    public String getHousekeeping() {
        String unDefinedCrew = "select_crew_name";
        String url = "/hotel/1/housekeepings/" + unDefinedCrew;
        return "redirect:" + url;
    }

    @RequestMapping(value="/hotel/{hotelId}/housekeepings/{crew}", method = GET)
    public String getHousekeepings(@PathVariable("hotelId") Long hotelId,
                                   @PathVariable("crew") String crewName,
                                   Model model) {
        model.addAttribute("crew", crewName);
        model.addAttribute("housekeepings", getHousekeepingDtoList(hotelId));
        return "housekeeping/list";
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
        //model.addAttribute("history", getHousekeepingHistoryDto(housekeepingId));
        return "housekeeping/edit";
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

    private Housekeeping getHousekeeping(Long housekeepingId) {
        Housekeeping housekeeping = housekeepingService.findById(housekeepingId);
        if(housekeeping == null) {
            logger.error("housekeeping find by housekeepingId Error: {}", housekeepingId);
            throw new HousekeepingNotFoundException("housekeeping find by housekeepingId Error: " + housekeepingId);
        }
        return housekeeping;
    }

    private HousekeepingDto getHousekeepingDto(Long housekeepingId) {
        return HousekeepingDto.toDto(getHousekeeping(housekeepingId));
    }


    private Housekeeping getHousekeeping(final HousekeepingDto dto) {
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

    @RequestMapping(value="/hotel/{hotelId}/housekeeping/{housekeepingId}/{crew}", method = POST)
    public String saveHousekeeping(
            @PathVariable("hotelId") Long hotelId,
            @PathVariable("housekeepingId") Long housekeepingId,
            @ModelAttribute HousekeepingDto dto,
            @PathVariable("crew") String crewName,
            BindingResult result,
            Model model) {

        logger.info("saveHousekeeping: {}, {}",  dto.toString(), crewName);
        housekeepingService.save(getHousekeeping(dto), getCrew(crewName));
        String url = "/hotel/1/housekeepings/" + crewName;
        return "redirect:" + url;
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
