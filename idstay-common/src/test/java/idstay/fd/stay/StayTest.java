package idstay.fd.stay;

import idstay.TestConfig;
import idstay.frontdesk.booking.Stay;
import idstay.frontdesk.booking.StayPeriod;
import idstay.frontdesk.booking.support.StayRepository;
import idstay.frontdesk.common.BookingChannel;
import idstay.profiles.hotelguest.HotelGuestProfile;
import idstay.profiles.hotelguest.support.HotelGuestProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
@ActiveProfiles(profiles = "standalone")
public class StayTest {

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private HotelGuestProfileRepository hotelGuestProfileRepository;


    @Test
    public void foo() throws ParseException {

        StayPeriod stayPeriod = new StayPeriod("2016.01.01", "2016.01.03");
        Stay stay = new Stay(stayPeriod);
        stay.setBookingChannel(BookingChannel.Reservation);

        Stay savedStay = stayRepository.save(stay);

        HotelGuestProfile profile = new HotelGuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");
        HotelGuestProfile savedProfile = hotelGuestProfileRepository.save(profile);

        savedStay.setHotelGuestProfile(savedProfile);

        savedStay = stayRepository.save(stay);




        System.out.println(savedStay);

//
//        this.entityManager.persist(new Stay(1L, stayPeriod));
    }
}

//    private Long hotelId;
//    private Room r101;
//    Date fromDate;
//    Date toDate;
//
//
//    @Before
//    public void setUp() throws Exception {
//        r101 = new Room();
//        hotelId = 1L;
//        fromDate = new Date();
//        toDate = new Date();
//    }
//
//    @Test public void
//    testx() {
//
//        assertThat(1, is(1));
//
//        Customer customer = new Customer();
//
//
//        StayRepository stayRepository = new StayRepository();
//        StayService stayService = new StayService();
//        stayService.setStayService(stayRepository);
//
//        assertThat(stayService.getStays(hotelId, new Date()).get(), is(notNullValue()));
//
//    }
//
//    @Test public void test2() {
//        CustomerStayProfileService  customerStayProfileServce = new CustomerStayProfileService();
//        assertThat(customerStayProfileServce.getProfiles(hotelId, new Date()), is(notNullValue()));
//    }
//
//
//}
//
//class Stay {
//    private Customer customer;
//    public Stay(Room room, DatePeriod period) {}
//    public void setCustomer(Customer customer) {
//
//    }
//}
//
//class DatePeriod {
//    private Date startDate;
//    private Date endDate;
//    private int nights;
//
//    public DatePeriod(Date startDate, Date endDate) {
//    }
//
//    public DatePeriod(Date startDate, int nights) {
//    }
//}
//
//class Customer {
//
//}
//
//
//
//class StayRepository {}
//
//class StayService {
//    private StayRepository stayRepository;
//
//
//    public void setStayService(StayRepository stayRepository) {
//    }
//
//    public Optional<List<Stay>> getStays(Long hotelId, Date date) {
//        return null;
//    }
//}
//
//class CustomerStayProfile {
//    private Stay stay;
//    private Customer customer;
//    private Set<Payment> payments;
//}
//
//class PaymentMethod {
//
//}
//
//class Payment {
//    private PaymentMethod paymentMethod;
//
//}
//
//class CustomerStayProfileService {
//
//    public Optional<List<CustomerStayProfile>> getProfiles(Long hotelId, Date date) {
//    }
