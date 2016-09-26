package idstay.hotelconfig.hotel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="room_id")
    private Long id;
    private String roomName;
    private int floor;
    private int sortId = 0;

    @ManyToOne
    @JoinColumn(name="room_type_id", nullable = false)
    private RoomType roomType;
    private Long hotelId;

    protected Room() {}
    public Room(final String roomName, final RoomType roomType) {
        this.roomName = roomName;
        this.roomType = roomType;
    }

    /* For testing only */
    public Room(final Long id, final String roomName, final int floor, final int sortId, final RoomType roomType) {
        this(roomName, roomType);
        this.id = id;
        this.floor = floor;
        this.sortId = sortId;
        this.hotelId = roomType.getHotel().getId();
    }

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getFloor() {
        return floor;
    }

    public int getSortId() {
        return floor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public long getHotelId() {
        return hotelId;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Room)) {
            return false;
        }
        return (id == ((Room)object).id) ? true : false;
    }

    public int hashCode() {
        return id.intValue();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("roomName", roomName)
                .append("roomType", roomType)
                .toString();
    }
}