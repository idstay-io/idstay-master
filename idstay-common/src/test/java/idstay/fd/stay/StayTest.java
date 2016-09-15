package idstay.fd.stay;

import idstay.configuration.hotel.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StayTest {
    private Long hotelId;
    private Room r101;
    Date fromDate;
    Date toDate;


    @Before
    public void setUp() throws Exception {
        r101 = new Room();
        hotelId = 1L;
        fromDate = new Date();
        toDate = new Date();
    }

    @Test public void
    testx() {

        assertThat(1, is(1));
        
        Customer customer = new Customer();
        

        StayRepository stayRepository = new StayRepository();
        StayService stayService = new StayService();
        stayService.setStayService(stayRepository);

        assertThat(stayService.getStays(hotelId, new Date()).get(), is(notNullValue()));
        
    }

    @Test public void test2() {
        CustomerStayProfileService  customerStayProfileServce = new CustomerStayProfileService();
        assertThat(customerStayProfileServce.getProfiles(hotelId, new Date()), is(notNullValue()));
    }


}

class Stay {
    private Customer customer;
    public Stay(Room room, DatePeriod period) {}
    public void setCustomer(Customer customer) {

    }
}

class DatePeriod {
    private Date startDate;
    private Date endDate;
    private int nights;

    public DatePeriod(Date startDate, Date endDate) {
    }

    public DatePeriod(Date startDate, int nights) {
    }
}

class Customer {

}



class StayRepository {}

class StayService {
    private StayRepository stayRepository;


    public void setStayService(StayRepository stayRepository) {
    }

    public Optional<List<Stay>> getStays(Long hotelId, Date date) {
        return null;
    }
}

class CustomerStayProfile {
    private Stay stay;
    private Customer customer;
    private Set<Payment> payments;
}

class PaymentMethod {

}

class Payment {
    private PaymentMethod paymentMethod;

}

class CustomerStayProfileService {

    public Optional<List<CustomerStayProfile>> getProfiles(Long hotelId, Date date) {
    }
}