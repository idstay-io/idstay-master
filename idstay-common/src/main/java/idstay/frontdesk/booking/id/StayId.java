package idstay.frontdesk.booking.id;

import idstay.common.util.UUIDUtil;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
@Embeddable
public class StayId implements Serializable{
    @Column(name = "stay_id")
    private String id;

    public StayId(final String id) {
        this.id = id;
    }

    public static StayId newId() {
        return new StayId(UUIDUtil.getUUID());
    }

    @Override
    public String toString() {
        return "StayId{" +
                "id='" + id + '\'' +
                '}';
    }

}
