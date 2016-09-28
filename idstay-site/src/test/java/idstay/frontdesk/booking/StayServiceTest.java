package idstay.frontdesk.booking; /**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 26.
 */


import idstay.IdstaySite;
import idstay.crm.HotelGuestSpending;
import idstay.crm.support.HotelGuestSpendingRepository;
import idstay.payment.support.PaymentLineRepository;
import idstay.profiles.hotelguest.HotelGuestProfile;
import idstay.profiles.hotelguest.support.HotelGuestProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IdstaySite.class)
@ActiveProfiles(profiles = "standalone")

public class StayServiceTest {
    @Autowired
    private StayService stayService;

    @Autowired
    private HotelGuestProfileRepository profileRepository;

    @Autowired
    private HotelGuestSpendingRepository hotelGuestSpendingRepository;


    @Autowired
    private PaymentLineRepository paymentLineRepository;


    @Test
    public void foo() throws ParseException {
        assertThat(stayService, is(notNullValue()));
        StayPeriod period = new StayPeriod("2016.01.01", "2016.01.02");
        HotelGuestProfile profile = new HotelGuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");

        profile = profileRepository.save(profile);

        Stay stay = stayService.registerStayInfo(period, profile).get();

        assertThat(stay, is(notNullValue()));
        assertThat(stay.getId(), is(2L));

        HotelGuestSpending spending = new HotelGuestSpending(stay);

        spending = hotelGuestSpendingRepository.save(spending);

        assertThat(spending.getId(), is(notNullValue()));





    }

}
