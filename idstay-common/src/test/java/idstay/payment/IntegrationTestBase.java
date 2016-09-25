package idstay.payment;

import idstay.TestConfig;
import idstay.hotelconfig.hotel.Hotel;
import idstay.hotelconfig.hotel.Room;
import idstay.hotelconfig.hotel.RoomType;
import idstay.hotelconfig.hotel.support.HotelRepository;
import idstay.hotelconfig.hotel.support.RoomRepository;
import idstay.hotelconfig.hotel.support.RoomTypeRepository;
import idstay.testutils.HotelBuilder;
import idstay.testutils.RoomBuilder;
import idstay.testutils.RoomTypeBuilder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.expression.ParseException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
@ActiveProfiles("standalone")
@Transactional
public class IntegrationTestBase {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public void init() throws ParseException {
        Hotel MAKERS_HOTEL = hotelRepository.save(HotelBuilder.hotel().hotelName("MAKERS HOTEL").build());

        RoomType MODERN_DOUBLE = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("MODERN_DOUBLE").build();
        MODERN_DOUBLE = roomTypeRepository.save(MODERN_DOUBLE);

        RoomType SEMI_DOUBLE = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("SEMI_DOUBLE").build();
        SEMI_DOUBLE = roomTypeRepository.save(SEMI_DOUBLE);

        RoomType CLASSIC_TWIN = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("CLASSIC_TWIN").build();
        CLASSIC_TWIN = roomTypeRepository.save(CLASSIC_TWIN);

        RoomType DORMITORY_TWIN = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("DORMITORY_TWIN").build();
        DORMITORY_TWIN = roomTypeRepository.save(DORMITORY_TWIN);

        RoomType DORMITORY_TRIPLE = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("DORMITORY_TRIPLE").build();
        DORMITORY_TRIPLE = roomTypeRepository.save(DORMITORY_TRIPLE);

        RoomType MAKERS_SUITE = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("MAKERS_SUITE").build();
        MAKERS_SUITE = roomTypeRepository.save(MAKERS_SUITE);

        RoomType ACCESSIBLE_DOUBLE = RoomTypeBuilder.roomType().hotel(MAKERS_HOTEL).roomTypeName("ACCESSIBLE_DOUBLE").build();
        ACCESSIBLE_DOUBLE = roomTypeRepository.save(ACCESSIBLE_DOUBLE);


        Room r301 = RoomBuilder.room().roomType(MODERN_DOUBLE).roomName("301").build();
        roomRepository.save(r301);

        Room r401 = RoomBuilder.room().roomType(MODERN_DOUBLE).roomName("401").build();
        roomRepository.save(r401);

        Room r501 = RoomBuilder.room().roomType(MODERN_DOUBLE).roomName("501").build();
        roomRepository.save(r501);


        Room r601 = RoomBuilder.room().roomType(MODERN_DOUBLE).roomName("601").build();
        roomRepository.save(r601);

        Room r202 = RoomBuilder.room().roomType(CLASSIC_TWIN).roomName("202").build();
        roomRepository.save(r202);

        Room r302 = RoomBuilder.room().roomType(CLASSIC_TWIN).roomName("302").build();
        roomRepository.save(r302);

        Room r402 = RoomBuilder.room().roomType(CLASSIC_TWIN).roomName("402").build();
        roomRepository.save(r402);

        Room r502 = RoomBuilder.room().roomType(CLASSIC_TWIN).roomName("502").build();
        roomRepository.save(r502);


        Room r602 = RoomBuilder.room().roomType(CLASSIC_TWIN).roomName("602").build();
        roomRepository.save(r602);

    }





    public RoomRepository getRoomRepository() {
        return this.roomRepository;
    }

    public RoomTypeRepository getRoomTypeRepository() {
        return this.roomTypeRepository;
    }

    public HotelRepository getHotelRepository() {
        return this.hotelRepository;
    }



}
