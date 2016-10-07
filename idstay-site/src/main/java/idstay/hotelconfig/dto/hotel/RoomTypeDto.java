package idstay.hotelconfig.dto.hotel;

import idstay.backoffice.config.hotel.RoomType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RoomTypeDto {
    private String roomTypeName;

    public RoomTypeDto(final String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public static RoomTypeDto toDto(RoomType roomType) {
        return new RoomTypeDto(roomType.getRoomTypeName());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("roomTypeName", roomTypeName)
                .toString();
    }
}
