package idstay.frontdesk.booking;

import org.apache.commons.lang3.Validate;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 9. 24.
 */

@Entity
@Table(name="stay")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stay_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", insertable = false, updatable = false)
    @OrderColumn(name = "seq")
    private Booking booking;

    @Embedded
    private StayPeriod stayPeriod;





//    @OneToMany
//    @JoinColumn(name = "stay_id")
//    private List<StayLine> stayLines = new ArrayList<StayLine>();







    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stay_id")
//    @OrderColumn(name="stay_idx")
    private List<StayLine> stayLines = new ArrayList<StayLine>();
//
//    private Long hotelGuestProfileId;
//
    protected Stay() {}
    public Stay(final StayInfo stayInfo, final Long roomId) {
        Validate.notNull(stayInfo, "stayInfo is required");
        Validate.notNull(roomId, "roomId is required");

        this.stayLines.add(new StayLine(stayInfo.getStayPeriod(), roomId));


    }

//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public StayInfo getStayInfo() {
//        return stayInfo;
//    }
//
//    public Long getHotelGuestProfileId() {
//        return hotelGuestProfileId;
//    }
//
//    @Override
//    public String toString() {
//        return "Stay{" +
//                "id=" + id +
//                ", stayInfo=" + stayInfo +
//                ", hotelGuestProfileId=" + hotelGuestProfileId +
//                '}';
//    }
}