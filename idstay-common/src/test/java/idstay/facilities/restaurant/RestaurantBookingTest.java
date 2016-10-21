package idstay.facilities.restaurant;

import idstay.common.util.DateTimeUtil;
import idstay.facilities.booking.restaurant.RestaurantBooking;
import idstay.facilities.booking.restaurant.RestaurantBookingParam;
import idstay.facilities.booking.restaurant.RestaurantBookingService;
import idstay.facilities.booking.restaurant.support.RestaurantBookingRepository;
import idstay.facilities.booking.shared.RestaurantTable;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;


/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("development")
public class RestaurantBookingTest {
    @Autowired
    private RestaurantBookingService service;

    @MockBean
    private RestaurantBookingRepository repository;

    @Test
    public void getBookingListTest(){
        List<RestaurantBooking> bookingList = new ArrayList<RestaurantBooking>();
        given(repository.findByhotelFacilityIdAndBookingDate(anyLong(), anyString())).willReturn(bookingList);
        assertThat(service.getBookingList(anyLong(), anyString()), is(notNullValue()));
    }

    @Test
    public void getBookingDetailTest(){
        service.getBooking(1L);
        verify(repository, times(1)).findOne(anyLong());
    }

    @Test
    public void makeReservation(){
        RestaurantBookingParam param = new RestaurantBookingParam.ParamBuilder(1L,"2016.01.01", "10:30", "11:30")
                .bookingTable(idstay.facilities.booking.shared.RestaurantTable.Table_1)
                .bookingTable(idstay.facilities.booking.shared.RestaurantTable.Table_2)
                .build();

        service.makeBooking(param);
    }

    @Test
    public void isBookableTest(){
        Date fromDate = DateTimeUtil.toDate("2016.01.01","10:30");
        Date toDate = DateTimeUtil.toDate("2016.01.01","11:00");
        Set<RestaurantTable> bookedtables = new HashSet<RestaurantTable>();
        bookedtables.add(RestaurantTable.Table_1);
        bookedtables.add(idstay.facilities.booking.shared.RestaurantTable.Table_2);

        RestaurantBooking booking1 = new RestaurantBooking(1L,"2016.01.01", fromDate, toDate, "minsoo");
        booking1.setTables(bookedtables);


        Date bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:00");
        Date bookingToDate = DateTimeUtil.toDate("2016.01.01","10:30");

        //예약된 테이블이 없을 경우
        Set<RestaurantTable> bookingTables = new HashSet<RestaurantTable>();
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(true));

        //예약된 테이블이 있고 경우 예약시간이 중복됨
        bookingTables.add(idstay.facilities.booking.shared.RestaurantTable.Table_1);
        bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:00");
        bookingToDate = DateTimeUtil.toDate("2016.01.01","10:40");
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(false));

        bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:20");
        bookingToDate = DateTimeUtil.toDate("2016.01.01","11:00");
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(false));

        bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:00");
        bookingToDate = DateTimeUtil.toDate("2016.01.01","11:00");
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(false));

        bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:40");
        bookingToDate = DateTimeUtil.toDate("2016.01.01","10:50");
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(false));

        //테이블이 겹치지 않음
        bookingFromDate = DateTimeUtil.toDate("2016.01.01","10:40");
        bookingToDate = DateTimeUtil.toDate("2016.01.01","10:50");
        bookedtables.clear();
        bookedtables.add(idstay.facilities.booking.shared.RestaurantTable.Table_3);
        assertThat(booking1.isBookable(bookingFromDate, bookingToDate, bookingTables), is(true));
    }

}
