package idstay.crm;


import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrmTest {
//    @Mock
//    HotelGuestUseRepository hotelGuestUseRepository;
//
//    HotelGuestUseService hotelGuestUseService = new HotelGuestUseService();
//
//    @Before
//    public void setUp() {
//        hotelGuestUseService.setHotelGuestUseRepository(hotelGuestUseRepository);
//    }
//
//
//
//    @Test
//    public void fooTest() {
//        given(hotelGuestUseRepository.findByDate(anyObject())).willReturn(new ArrayList<HotelGuestUse>());
//        List<HotelGuestUse> list = hotelGuestUseService.getDayUse(DateTimeUtil.getLocalDate());
//        assertThat(list, is(notNullValue()));
//
//
//
//    }
}


//class HotelGuestUse {
//
//    private Long id;
//
//    @ManyToOne
//    private StayLine roomOccupancy;
//    @ManyToOne
//    private HotelGuest hotelGuest;
//
//    //protected HotelGuest() {}
//    public HotelGuestUse(StayLine roomOccupancy, HotelGuest hotelGuest) {
//        this.roomOccupancy = roomOccupancy;
//        this.hotelGuest = hotelGuest;
//    }
//
//    /* for junit test only */
//    public HotelGuestUse(Long id, StayLine roomOccupancy, HotelGuest hotelGuest) {
//        this(roomOccupancy, hotelGuest);
//        this.id = id;
//    }
//}
//
//class HotelGuestUseService {
//    private HotelGuestUseRepository hotelGuestUseRepository;
//
//    public List<HotelGuestUse> getDayUse(Date date) {
//        return hotelGuestUseRepository.findByDate(date);
//    }
//
//    public void setHotelGuestUseRepository(HotelGuestUseRepository hotelGuestUseRepository) {
//        this.hotelGuestUseRepository = hotelGuestUseRepository;
//    }
//}
//
//class HotelGuestUseRepository {
//    public List<HotelGuestUse> findByDate(Date date) {
//        return null;
//    }
//
//
//}
//
