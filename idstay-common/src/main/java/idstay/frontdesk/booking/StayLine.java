package idstay.frontdesk.booking;


import idstay.frontdesk.booking.StayPeriod;

import javax.persistence.*;

@Entity
@Table
public class StayLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stay_line_id")
    private Long id;


    private Long roomId;

    @Embedded
    private StayPeriod stayPeriod;

//    private Long hotelGuestProfileId;

    protected StayLine() {}
    public StayLine(final StayPeriod stayPeriod, final Long roomId) {
        this.roomId = roomId;
       this.stayPeriod = stayPeriod;
    }

    public Long getRoomId() {
        return roomId;
    }
}

