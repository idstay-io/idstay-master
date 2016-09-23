package idstay.frontdesk.booking;

import idstay.TestConfig;
import idstay.hotelconfig.hotel.Hotel;
import idstay.hotelconfig.hotel.Room;
import idstay.hotelconfig.hotel.RoomType;
import idstay.hotelconfig.hotel.support.HotelRepository;
import idstay.hotelconfig.hotel.support.RoomRepository;
import idstay.hotelconfig.hotel.support.RoomTypeRepository;
import idstay.frontdesk.booking.support.BookingRepository;
import idstay.frontdesk.booking.support.RoomOccupancyRepository;
import idstay.profiles.hotelguest.HotelGuest;
import idstay.profiles.hotelguest.support.HotelGuestRepository;
import idstay.testutils.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class BookingIntegrationTest {
    @Autowired
    private RoomOccupancyRepository roomOccupancyRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private HotelGuestRepository hotelGuestRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    @Transactional
    public void foo() {
        Hotel makers = hotelRepository.save(HotelBuilder.hotel().hotelName("MAKERS HOTEL").build());
        RoomType roomType = RoomTypeBuilder.roomType()
                .hotel(makers)
                .roomTypeName("CLSSIC")
                .build();

        RoomType classic = roomTypeRepository.save(roomType);
        Room room =
                RoomBuilder.room().roomType(classic)
                        .roomName("201")
                        .build();
        Room r201 = roomRepository.save(room);

        HotelGuest hotelGuest = HotelGuestBuilder.hotelGuest().email("minsoo.kim@jkglobe.com").build();

        HotelGuest minsoo = hotelGuestRepository.save(hotelGuest);





        //Room room = roomRepository.save(RoomBuilder.room().build());

        assertThat(makers.getId(), is(1L));


    }
}
