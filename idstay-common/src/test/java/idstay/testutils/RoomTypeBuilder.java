package idstay.testutils;


import idstay.configuration.hotel.Hotel;
import idstay.configuration.hotel.RoomType;

public class RoomTypeBuilder {
    private long id;
    private String roomTypeName;
    private int sortId = 0;
    private Hotel hotel;

    public RoomTypeBuilder() {
        this.id = 1L;
        this.roomTypeName = "CLASSIC";
        this.sortId = 1;
        this.hotel = HotelBuilder.hotel().build();
    }

    public static RoomTypeBuilder roomType() {
        return new RoomTypeBuilder();
    }

    public RoomTypeBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public RoomTypeBuilder roomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
        return this;
    }

    public RoomTypeBuilder sortId(int sortId) {
        this.sortId = sortId;
        return this;
    }

    public RoomTypeBuilder hotel(Hotel hotel) {
        this.hotel = hotel;
        return this;
    }

    public RoomType build() {
        return new RoomType(id, roomTypeName, sortId, hotel);
    }



}
