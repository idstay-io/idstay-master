package idstay.fd.guest;

import idstay.customer.Customer;
import idstay.customer.CustomerService;
import idstay.fd.guest.support.HotelGuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelGuestServiceTest {
    @Mock
    private HotelGuestRepository hotelGuestRepository;
    private HotelGuestService hotelGuestService;

    @Before
    public void setUp() {
        hotelGuestService = new HotelGuestService();
        hotelGuestService.setHotelGuestRepository(hotelGuestRepository);
    }

    @Test
    public void test_Guest_정보가_있는경우() {
        String email = "minsoo.kim@jkglobe.com";
        String name = "KIM MINSOO";
        HotelGuest param = new HotelGuest(name);
        param.setEmail(email);

        when(hotelGuestRepository.findByEmail(email)).thenReturn(Optional.of(new HotelGuest(email)));

        assertThat(hotelGuestService.findOrCreateHotelGuest(param), is(param));
    }

    @Test
    public void test_Customer_정보가_없는_경우() {
        String name = "KIM MINSOO";
        HotelGuest param = new HotelGuest(name);
        HotelGuest rHotelGuest = new HotelGuest(name);

        when(hotelGuestRepository.save(param)).thenReturn(rHotelGuest);

        assertThat(hotelGuestService.createHotelGuest(param).getName(), is(name));
    }
}