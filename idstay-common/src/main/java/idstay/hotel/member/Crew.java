package idstay.hotel.member;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="crew_id")
    private long id;
    private String crewName;
    private Locale locale;
    private boolean activate = true;

    protected Crew() {}
    public Crew(final long id) {
        this.id = id;
    }
    public Crew(final String crewName, final Locale locale, boolean activate) {
        this.crewName = crewName;
        this.locale = locale;
        this.activate = activate;
    }

    public long getId() {
        return id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewId(String crewName) {
        this.crewName = crewName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocalse(Locale locale) {
        this.locale = locale;
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("crewName", crewName)
                .append("locale", locale)
                .append("activate", activate)
                .toString();
    }

}