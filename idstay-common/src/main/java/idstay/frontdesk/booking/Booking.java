package idstay.frontdesk.booking;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 7.
 */

@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Long id;

    @Embedded
    private StayInfo stayInfo;

    private Long roomId;
    private Long guestProfileId;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "booking_id")
    private List<Stay> stays = new ArrayList<Stay>();

    protected Booking() {}
    public Booking(StayInfo stayInfo, Long roomId) {
        Validate.notNull(stayInfo, "stayInfo in is required");
        Validate.notNull(roomId, "roomId in is required");
        this.stayInfo = stayInfo;
        this.roomId = roomId;
    }

    public static Booking newInstance() {
        return new Booking();
    }


    public Booking withStay(Stay stay) {
        this.stays.add(stay);
        return this;
    }



    public Long getId() {
        return id;
    }



}
