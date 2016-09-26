package idstay.payment;

import idstay.IntegrationTestBase;
import idstay.common.util.DateTimeUtil;
import idstay.crm.HotelGuestUse;
import idstay.crm.support.HotelGuestUseRepository;
import idstay.frontdesk.common.Currency;
import idstay.frontdesk.common.Payment;
import idstay.frontdesk.common.PaymentMethods;
import idstay.hotelconfig.hotel.Room;
import idstay.payment.support.PaymentInventoryRepository;
import idstay.profiles.hotelguest.HotelGuestProfile;
import idstay.profiles.hotelguest.support.HotelGuestProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
public class PaymentInventoryTest extends IntegrationTestBase {
    @Autowired
    PaymentInventoryRepository repository;

    @Autowired
    HotelGuestProfileRepository profileRepository;

    @Autowired
    HotelGuestUseRepository guestUseRepository;



    public PaymentInventoryTest() {
        super();
    }

    @Before
    public void setUp() {
        init();
    }

    @Test
    public void foo() {

        Room r202 = getRoomRepository().findOne(2L);

        Payment payment = new Payment(Currency.KRW, 1000);
        PaymentInventory paymentInventory = new PaymentInventory(PaymentMethods.Card, payment);
        paymentInventory.setRoom(r202);

        PaymentInventory p = repository.save(paymentInventory);

        Payment payment2 = new Payment(Currency.KRW, 1030);
        PaymentInventory paymentInventory2 = new PaymentInventory(PaymentMethods.Card, payment2);
        paymentInventory.setRoom(r202);
        PaymentInventory p2 = repository.save(paymentInventory2);



        HotelGuestProfile profile = new HotelGuestProfile("minsoo.kim@jkglobe.com", "KIM minsoo");
        profile = profileRepository.save(profile);

        HotelGuestUse hotelGuestUse = new HotelGuestUse(DateTimeUtil.getLocalDate(), profile);
        hotelGuestUse.setPaymentInventory(p);
        hotelGuestUse.setPaymentInventory(p2);
        hotelGuestUse.setPaymentInventory(p2);

        hotelGuestUse = guestUseRepository.save(hotelGuestUse);

        System.out.println(hotelGuestUse);


        assertThat(p.getId(), is(notNullValue()));

        System.out.println(p.toString());

    }

}
