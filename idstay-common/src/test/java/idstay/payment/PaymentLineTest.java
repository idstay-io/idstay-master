package idstay.payment;

import idstay.TestConfig;
//import idstay.crm.HotelGuestSpending;
//import idstay.payment.support.PaymentLineRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
@ActiveProfiles("standalone")
public class PaymentLineTest  {
//    @Autowired
//    RoomRepository roomRepository;
//
//    @Autowired
//    PaymentLineRepository repository;
//
//    @Autowired
//    GuestProfileRepository profileRepository;
//
//    @Autowired
//    PaymentLineRepository paymentLineRepository;
//
//    public PaymentLineTest() {
//        super();
//    }
//
//    @Before
//    public void setUp() {
//     //   init();
//    }
//
//    @Test
//    public void foo() {
//
//        Room r202 = roomRepository.findOne(2L);
//
//
//        PaymentLine pay1 = new PaymentLine(DateTimeUtil.getLocalDate(), PaymentMethods.Card, new Money(Currency.KRW, 500L));
//
//        pay1 = paymentLineRepository.save(pay1);
//
//        GuestProfile profile = new GuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");
//        profile = profileRepository.save(profile);
//
//        Stay stay = new Stay(new StayPeriod("2016.01.01", "2016.01.17"));
////        stay.
//
////        HotelGuestSpending hotelGuestSpending = new HotelGuestSpending()
//
//
//
//
////
////
////
////        Payment payment = new Payment(Currency.KRW, 1000);
////        PaymentLine paymentInventory = new PaymentLine(PaymentMethods.Card, payment);
////        paymentInventory.setRoom(r202);
////
////        PaymentLine p = repository.save(paymentInventory);
////
////        Payment payment2 = new Payment(Currency.KRW, 1030);
////        PaymentLine paymentInventory2 = new PaymentLine(PaymentMethods.Card, payment2);
////        paymentInventory.setRoom(r202);
////        PaymentLine p2 = repository.save(paymentInventory2);
////
////
////
////        GuestProfile profile = new GuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");
////        profile = profileRepository.save(profile);
////
////        HotelGuestUse hotelGuestUse = new HotelGuestUse(DateTimeUtil.getLocalDate(), profile);
////        hotelGuestUse.setPaymentInventory(p);
////        hotelGuestUse.setPaymentInventory(p2);
////        hotelGuestUse.setPaymentInventory(p2);
////
////        hotelGuestUse = guestUseRepository.save(hotelGuestUse);
////
////        System.out.println(hotelGuestUse);
////
////
////        assertThat(p.getId(), is(notNullValue()));
////
////        System.out.println(p.toString());
//
//    }

}
