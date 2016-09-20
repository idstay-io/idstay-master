package idstay.testutils;

import idstay.configuration.hotel.Room;
import idstay.configuration.hotel.RoomType;

public class RoomBuilder {
    private Long id;
    private String roomName;
    private int floor;
    private int sortId = 0;
    private RoomType roomType;
    private Long hotelId;

    public RoomBuilder() {
        id = 1L;
        roomName = "201";
        floor = 2;
        sortId = 0;
        roomType = RoomTypeBuilder.roomType().build();
        hotelId = HotelBuilder.hotel().build().getId();
    }

    public static RoomBuilder room() {
        return new RoomBuilder();
    }

    public RoomBuilder id(Long id){
        this.id = id;
        return this;
    }

    public RoomBuilder roomName(String roomName){
        this.roomName = roomName;
        return this;
    }

    public RoomBuilder floor(int floor){
        this.floor = floor;
        return this;
    }

    public RoomBuilder sortId(int sortId){
        this.sortId = sortId;
        return this;
    }

    public RoomBuilder roomType(RoomType roomType){
        this.roomType = roomType;
        return this;
    }

    public RoomBuilder hotelId(Long hotelId){
        this.hotelId = hotelId;
        return this;
    }

    public Room build() {
        return new Room(roomName, roomType);
    }
}
