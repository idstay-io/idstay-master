package idstay.housekeeping;

import idstay.housekeeping.common.Remarks;
import idstay.backoffice.config.crew.Crew;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="housekeeping_history")
public class HousekeepingHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="housekeepinghistory_id")
    private long id;
    private long housekeepingId = 0;
    private long hotelId = 0;
    private String hotelName = "";
    private long roomTypeId = 0;
    private String roomTypeName = "";
    private long roomId = 0;
    private String roomName = "";
    private String roomStatus = "";
    private String cleaningStatus = "";
    private String remarks = "";
    private String memo = "";
    private long lastUpdateCrewId = 0;
    private String lastUpdateCrewName = "";
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    protected HousekeepingHistory() {}
    public HousekeepingHistory(final long housekeepingId, final long lastUpdateCrewId) {
        this.housekeepingId = housekeepingId;
        this.lastUpdateCrewId = lastUpdateCrewId;
        this.lastUpdate = new Date();
    }
    public long getId() {
        return id;
    }

    public HousekeepingHistory setId(long id) {
        this.id = id;
        return this;
    }

    public long getHousekeepingId() {
        return housekeepingId;
    }

    public HousekeepingHistory setHousekeepingId(long housekeepingId) {
        this.housekeepingId = housekeepingId;
        return this;
    }

    public long getHotelId() {
        return hotelId;
    }

    public HousekeepingHistory setHotelId(long hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public String getHotelName() {
        return hotelName;
    }

    public HousekeepingHistory setHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public long getRoomTypeId() {
        return roomTypeId;
    }

    public HousekeepingHistory setRoomTypeId(long roomTypeId) {
        this.roomTypeId = roomTypeId;
        return this;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public HousekeepingHistory setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
        return this;
    }

    public long getRoomId() {
        return roomId;
    }

    public HousekeepingHistory setRoomId(long roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public HousekeepingHistory setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public HousekeepingHistory setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
        return this;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public HousekeepingHistory setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public HousekeepingHistory setRemarks(Set<Remarks> remarks) {
        if (remarks.isEmpty()) {
            this.remarks = null;
        } else {
            StringBuilder remarksStr = new StringBuilder();
            for (Remarks remake: remarks) {
                remarksStr.append(remake.toString() + "|");
            }

            this.remarks = remarksStr.toString();
        }
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public HousekeepingHistory setMemo(String memo) {
        this.memo = memo;
        return this;
    }


    public long getLastUpdateCrewId() {
        return lastUpdateCrewId;
    }

    public HousekeepingHistory setLastUpdateCrewId(long lastUpdateCrewId) {
        this.lastUpdateCrewId = lastUpdateCrewId;
        return this;
    }

    public String getLastUpdateCrewName() {
        return lastUpdateCrewName;
    }

    public HousekeepingHistory setLastUpdateCrewName(String lastUpdateCrewName) {
        this.lastUpdateCrewName = lastUpdateCrewName;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public HousekeepingHistory setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public static HousekeepingHistory build(Housekeeping housekeeping, Crew crew) {
        HousekeepingHistory history = new HousekeepingHistory();

        return history.setHousekeepingId(housekeeping.getId())
                .setHotelId(housekeeping.getHotelId())
                .setHotelName(housekeeping.getRoomType().getHotel().getHotelName())
                .setRoomTypeId(housekeeping.getRoomType().getId())
                .setRoomTypeName(housekeeping.getRoomType().getRoomTypeName())
                .setRoomId(housekeeping.getRoom().getId())
                .setRoomName(housekeeping.getRoom().getRoomName())
                .setRoomStatus(housekeeping.getRoomStatus().toString())
                .setCleaningStatus(housekeeping.getCleaningStatus().toString())
                .setRemarks(housekeeping.getRemarks())
                .setMemo(housekeeping.getMemo())
                .setLastUpdateCrewId(crew.getId())
                .setLastUpdateCrewName(crew.getCrewName())
                .setLastUpdate(new Date());
    }
}