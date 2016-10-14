package idstay.common.util.infra;

import javax.persistence.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
@Entity
@Table(name = "entity_sequences")
public class EntitySequences {
    private Long SEQUENCE_INT = 10L;
    private Long SEQUENCE_INTERVAL = 1L;
    private Long SEQUENCE_MAX = 950L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entity_sequence_id")
    private Long id;
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private EntityName entityName;

    private Long nextVal = SEQUENCE_INT;

    protected EntitySequences() {}

    public EntitySequences(final EntityName entityName, final Long nextVal) {
        this.entityName = entityName;
        this.nextVal = nextVal;
    }

    public Long getNextVal() {
        if (isOverSequence())
            setInitNextVal();
        return nextVal + SEQUENCE_INTERVAL;
    }

    public EntitySequences nextValObject() {
        this.nextVal = getNextVal();
        return this;
    }

    private boolean isOverSequence() {
        return (nextVal + SEQUENCE_INTERVAL) >= SEQUENCE_MAX ? true : false;
    }

    private void setInitNextVal() {
        nextVal = SEQUENCE_INT;
    }
}
