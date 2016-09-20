package idstay.configuration.hotel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="room_type_id")
    private long id;
    private String roomTypeName;
    private int sortId = 0;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable = false)
    private Hotel hotel;

    protected RoomType() {}
    public RoomType(String roomTypeName, Hotel hotel) {
        this.roomTypeName = roomTypeName;
        this.sortId = sortId;
        this.hotel = hotel;
    }

    /* For testing only */
    public RoomType(Long id, String roomTypeName, int sortId, Hotel hotel) {
        this(roomTypeName, hotel);
        this.id = id;
        this.sortId = sortId;
    }

    public long getId() {
        return id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getSortId() {
        return sortId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof RoomType)) {
            return false;
        }

        return (id == ((RoomType)object).id) ? true : false;
    }

    public int hashCode() {
        return (int) id;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("roomTypeName", roomTypeName)
                .toString();
    }
}