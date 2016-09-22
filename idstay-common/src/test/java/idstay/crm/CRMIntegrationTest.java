package idstay.crm;

import idstay.IdstaySpringApplication;
import idstay.TestConfig;
import idstay.common.util.DateTimeUtil;
import idstay.configuration.hotel.Hotel;
import idstay.configuration.hotel.Room;
import idstay.configuration.hotel.RoomType;
import idstay.configuration.hotel.support.HotelRepository;
import idstay.configuration.hotel.support.RoomRepository;
import idstay.configuration.hotel.support.RoomTypeRepository;
import idstay.frontdesk.booking.RoomOccupancy;
import idstay.frontdesk.booking.RoomOccupancyService;
import idstay.frontdesk.booking.support.RoomOccupancyRepository;
import idstay.profiles.hotelguest.HotelGuest;
import idstay.profiles.hotelguest.support.HotelGuestRepository;
import idstay.testutils.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
@ActiveProfiles(profiles = "standalone")
public class CRMIntegrationTest {
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
    private RoomOccupancyService roomOccupancyService;

    @Test
    //@Transactional

    public void foo() throws ParseException {
        init();
        assertThat(roomOccupancyService.findByDate(DateTimeUtil.parseDate("2016.01.01")).size(), is(1));
        assertThat(roomOccupancyService.findByDate(DateTimeUtil.parseDate("2016.01.15")).size(), is(1));
        assertThat(roomOccupancyService.findByDate(DateTimeUtil.parseDate("2016.02.01")).size(), is(1));
        assertThat(roomOccupancyService.findByDate(DateTimeUtil.parseDate("2016.02.02")).size(), is(0));

        //assertThat(roomOccupancyRepository.findAll().size(), is(2));
    }

    void init() throws ParseException {
        Hotel makers = hotelRepository.save(HotelBuilder.hotel().hotelName("MAKERS HOTEL").build());
        RoomType roomType = RoomTypeBuilder.roomType()
                .hotel(makers)
                .roomTypeName("CLSSIC")
                .build();

        RoomType classic = roomTypeRepository.save(roomType);


        String[] rooms = {"201", "202"};

        // room 201 room occupancy -----------------

        for(String roomNumber : rooms) {
            Room room =
                    RoomBuilder.room().roomType(classic)
                            .roomName(roomNumber)
                            .build();
            Room r201 = roomRepository.save(room);

            HotelGuest hotelGuest = HotelGuestBuilder.hotelGuest().email("minsoo.kim@jkglobe.com").build();

            HotelGuest minsoo = hotelGuestRepository.save(hotelGuest);

            RoomOccupancy roomOccupancy = RoomOccupancyBuilder.roomOccupancy()
                    .room(r201)
                    .fromDate(DateTimeUtil.parseDate("2016.01.01"))
                    .toDate(DateTimeUtil.parseDate("2016.02.01"))
                    .hotelGuest(minsoo)
                    .build();

            RoomOccupancy occu01 = roomOccupancyRepository.save(roomOccupancy);
        }
    }
}

