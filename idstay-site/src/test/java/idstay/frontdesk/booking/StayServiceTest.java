package idstay.frontdesk.booking; /**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 26.
 */


import idstay.IdstaySite;
import idstay.frontdesk.booking.RoomOccupancyService;
import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.StayPeriod;
import idstay.frontdesk.booking.StayService;
import idstay.frontdesk.booking.support.RoomOccupancyRepository;
import idstay.hotelconfig.hotel.support.HotelRepository;
import idstay.hotelconfig.hotel.support.RoomRepository;
import idstay.hotelconfig.hotel.support.RoomTypeRepository;
import idstay.profiles.hotelguest.HotelGuestProfile;
import idstay.profiles.hotelguest.support.HotelGuestProfileRepository;
import idstay.profiles.hotelguest.support.HotelGuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IdstaySite.class)
@ActiveProfiles(profiles = "standalone")
@Transactional
public class StayServiceTest {
    @Autowired
    private StayService stayService;

    @Autowired
    private HotelGuestProfileRepository profileRepository;

    @Test
    public void foo() throws ParseException {
        assertThat(stayService, is(notNullValue()));
        StayPeriod period = new StayPeriod("2016.01.01", "2016.01.02");
        HotelGuestProfile profile = new HotelGuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");

        profile = profileRepository.save(profile);

        Stay stay = stayService.registerStayInfo(period, profile).get();

        assertThat(stay, is(notNullValue()));
        assertThat(stay.getId(), is(2L));
    }

}
