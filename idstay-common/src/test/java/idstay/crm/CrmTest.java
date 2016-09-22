package idstay.crm;


import idstay.common.util.DateTimeUtil;
import idstay.frontdesk.booking.RoomOccupancy;
import idstay.profiles.hotelguest.HotelGuest;
import idstay.profiles.hotelguest.support.HotelGuestRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.fail;

import idstay.configuration.hotel.Room;
import idstay.profiles.hotelguest.HotelGuest;
import idstay.profiles.hotelguest.HotelGuestService;
import idstay.testutils.RoomBuilder;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CrmTest {
    @Mock
    HotelGuestUseRepository hotelGuestUseRepository;

    HotelGuestUseService hotelGuestUseService = new HotelGuestUseService();

    @Before
    public void setUp() {
        hotelGuestUseService.setHotelGuestUseRepository(hotelGuestUseRepository);
    }



    @Test
    public void fooTest() {
        given(hotelGuestUseRepository.findByDate(anyObject())).willReturn(new ArrayList<HotelGuestUse>());
        List<HotelGuestUse> list = hotelGuestUseService.getDayUse(DateTimeUtil.getLocalDate());
        assertThat(list, is(notNullValue()));



    }
}


class HotelGuestUse {

    private Long id;

    @ManyToOne
    private RoomOccupancy roomOccupancy;
    @ManyToOne
    private HotelGuest hotelGuest;

    //protected HotelGuest() {}
    public HotelGuestUse(RoomOccupancy roomOccupancy, HotelGuest hotelGuest) {
        this.roomOccupancy = roomOccupancy;
        this.hotelGuest = hotelGuest;
    }

    /* for junit test only */
    public HotelGuestUse(Long id, RoomOccupancy roomOccupancy, HotelGuest hotelGuest) {
        this(roomOccupancy, hotelGuest);
        this.id = id;
    }
}

class HotelGuestUseService {
    private HotelGuestUseRepository hotelGuestUseRepository;

    public List<HotelGuestUse> getDayUse(Date date) {
        return hotelGuestUseRepository.findByDate(date);
    }

    public void setHotelGuestUseRepository(HotelGuestUseRepository hotelGuestUseRepository) {
        this.hotelGuestUseRepository = hotelGuestUseRepository;
    }
}

class HotelGuestUseRepository {
    public List<HotelGuestUse> findByDate(Date date) {
        return null;
    }


}

