package idstay.frontdesk.booking;

//import idstay.profiles.hotelguest.HotelGuest;

import org.junit.runner.RunWith;
        import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BookingFacadeTest {
//    @Mock
//    BookingService bookingService;
//
//    @Mock
//    HotelGuestProfileService hotelGuestService;
//
//    @Mock
//    StayService roomOccupancyService;
//
//    @Mock
//    BookingRules bookingRules;
//
//    BookingFacade facade = new BookingFacade();
//
//    @Before
//    public void setUp() {
//        facade.setBookingRules(bookingRules);
//        facade.setBookingService(bookingService);
//        facade.setHotelGuestService(hotelGuestService);
//    }
//
//    @Test
//    public void valid_stay_Test() {
//        //1. BookingRule에서 true이면
//        //1-1. GuestService에서 Guest가져오고
//        //1-2. BookingService에서 Save하고
//        //1-3. BookingReturn
//        StayInfo stayInfo = new StayInfo("2016.01.01", "2016.01.27", 1, 0);
//        HotelGuest guest = new HotelGuest("KIM minsoo");
//
//        //when(roomOccupancyService.isValidStay(stayInfo)).thenReturn(true);
//        given(bookingRules.isValidStay(anyObject(), anyObject())).willReturn(true);
//
//
//
//        facade.makeBook(RoomBuilder.room().build(), stayInfo, guest, new BookingChannelInformation());
//
//        verify(hotelGuestService, times(1)).getBookingGuest(guest);
//        verify(bookingService, times(1)).makeReservation(anyObject());
//    }
//
//    @Test
//    public void invalid_stay_Test() {
//        StayInfo stayInfo = new StayInfo("2016.01.01", "2016.01.27", 1, 0);
//        HotelGuest guest = new HotelGuest("KIM minsoo");
//        Room room = RoomBuilder.room().build();
//        given(bookingRules.isValidStay(anyObject(), anyObject())).willReturn(false);
//        facade.makeBook(room, stayInfo, guest, new BookingChannelInformation());
//        verify(bookingRules, times(1)).isValidStay(RoomBuilder.room().build(), stayInfo);
//        assertThat(facade.makeBook(room, stayInfo, guest, new BookingChannelInformation()), is(Optional.empty()));
//
//    }
//

}