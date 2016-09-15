package idstay.housekeeping.dto;

import idstay.housekeeping.Housekeeping;
import idstay.housekeeping.common.CleaningStatus;
import idstay.housekeeping.common.Remarks;
import idstay.housekeeping.common.ReservationStatus;
import idstay.housekeeping.common.RoomStatus;
import idstay.configuration.hotel.dto.RoomDto;
import idstay.configuration.hotel.dto.RoomTypeDto;
import idstay.configuration.crew.dto.CrewDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class HousekeepingDto {
    private long housekeepingId = -1L;
    private RoomDto room;
    private CrewDto crew;
    private RoomTypeDto roomType;
    private ReservationStatus reservationStatus;
    private RoomStatus roomStatus;
    private CleaningStatus cleaningStatus;
    private Set<Remarks>remarks;
    private String memo ="";
    private Date lastUpdate;

    public HousekeepingDto() {}
    public HousekeepingDto(long id) {
        this.housekeepingId = id;
    }

    public long getHousekeepingId() {
        return housekeepingId;
    }

    public HousekeepingDto setHousekeepingId(long housekeepingId) {
        this.housekeepingId = housekeepingId;
        return this;
    }

    public RoomDto getRoom() {
        return room;
    }

    public HousekeepingDto setRoom(RoomDto room) {
        this.room = room;
        return this;
    }

    public CrewDto getCrew() {
        return crew;
    }

    public HousekeepingDto setCrew(CrewDto crew) {
        this.crew = crew;
        return this;
    }

    public RoomTypeDto getRoomType() {
        return roomType;
    }

    public HousekeepingDto setRoomType(RoomTypeDto roomType) {
        this.roomType = roomType;
        return this;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public HousekeepingDto setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
        return this;
    }


    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public HousekeepingDto setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
        return this;
    }

    public CleaningStatus getCleaningStatus() {
        return cleaningStatus;
    }

    public HousekeepingDto setCleaningStatus(CleaningStatus cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
        return this;
    }

    public Set<Remarks> getRemarks() {
        return remarks;
    }

    public HousekeepingDto setRemarks(Set<Remarks> remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public String getLastUpdate() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a EEE yyyy.MM.dd");
        if (this.lastUpdate == null) this.lastUpdate = new Date();
        return format.format(lastUpdate);
    }

    public HousekeepingDto setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("housekeepingId", housekeepingId)
                .append("RoomDto", room)
                .append("CrewDto", crew)
                .append("RoomTypeDto", roomType)
                .append("ReservationStatus", reservationStatus)
                .append("RoomStatus", roomStatus)
                .append("CleaningStatus", cleaningStatus)
                .append("Remarks", remarks)
                .append("memo", memo)
                .toString();
    }

    public static HousekeepingDto toDto(Housekeeping housekeeping) {
        HousekeepingDto dto = new HousekeepingDto(housekeeping.getId());
        return dto.setRoom(RoomDto.toDto(housekeeping.getRoom()))
                .setRoomType(RoomTypeDto.toDto(housekeeping.getRoomType()))
                .setReservationStatus(housekeeping.getReservationStatus())
                .setRoomStatus(housekeeping.getRoomStatus())
                .setCleaningStatus(housekeeping.getCleaningStatus())
                .setRemarks(housekeeping.getRemarks())
                .setMemo(housekeeping.getMemo());
    }

    public static List<HousekeepingDto> toList(List<Housekeeping> housekeepings) {
        List<HousekeepingDto >list = new ArrayList<HousekeepingDto>();
        for(Housekeeping housekeeping : housekeepings) {
            list.add(HousekeepingDto.toDto(housekeeping));
        }
        return list;
    }

}
