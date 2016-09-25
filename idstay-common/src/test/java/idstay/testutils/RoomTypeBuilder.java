package idstay.testutils;


import idstay.hotelconfig.hotel.Hotel;
import idstay.hotelconfig.hotel.RoomType;

public class RoomTypeBuilder {
    private Long id ;
    private String roomTypeName;
    private int sortId = 0;
    private Hotel hotel;

    public RoomTypeBuilder() {
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
        if (id != null)
            return new RoomType(id, roomTypeName, sortId, hotel);

        return new RoomType(roomTypeName, hotel);
    }



}
