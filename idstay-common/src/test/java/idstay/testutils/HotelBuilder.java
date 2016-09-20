package idstay.testutils;


import idstay.configuration.hotel.Hotel;

public class HotelBuilder {
    private Long id;
    private String hotelName;

    public HotelBuilder() {
        id = 1L;
        hotelName = "MAKERS HOTEL";
    }

    public static HotelBuilder hotel() {
        return new HotelBuilder();
    }

    public HotelBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public HotelBuilder hotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public Hotel build() {
        return new Hotel(id, hotelName);
    }
}
