package idstay.guestmanagement.hotelguest;

import static org.junit.Assert.*;


//import idstay.profiles.customer.CustomerService;
//import idstay.profiles.hotelguest.support.HotelGuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Matchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelGuestServiceTest {
//    @Mock
//    HotelGuestRepository hotelGuestRepository;
//
//    @Mock
//    CustomerService customerService;
//
//    HotelGuestProfileService hotelGuestService = new HotelGuestProfileService();
//
//    @Before
//    public void setUp() {
//        hotelGuestService.setHotelGuestRepository(hotelGuestRepository);
//        hotelGuestService.setCustomerService(customerService);    }
//
//    @Test
//    public void identifiable_guest() {
//        HotelGuest hotelGuest = new HotelGuest("KIM minsoo");
//        hotelGuest.setEmail("minsoo.kim@jkglobe.com");
//        given(hotelGuestRepository.findByEmail(anyString())).willReturn(Optional.of(hotelGuest));
//
//        assertThat(hotelGuestService.getBookingGuest(hotelGuest), is(hotelGuest));
//    }
//
//    @Test
//    public void dis_identifiable_guest() {
//        HotelGuest hotelGuest = new HotelGuest("KIM minsoo");
//        given(hotelGuestRepository.findByEmail(anyString())).willReturn(Optional.of(hotelGuest));
//
//        given(hotelGuestRepository.save(hotelGuest)).willReturn(hotelGuest);
//        assertThat(hotelGuestService.getBookingGuest(hotelGuest), is(hotelGuest));
//    }

}