package idstay.common.util.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
@Service
public class EntityIdUtil {
    private EntitySequencesRepository entitySequencesRepository;


    public String getID(final EntityName entityName) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());

        int yeardigit = today.get(Calendar.YEAR) - 2000;

        return String.format("%s-%2d%03d-%03d", getHeader(entityName), yeardigit, today.get(Calendar.DAY_OF_YEAR), getNextVal(entityName));
    }


    @Transactional
    private Long getNextVal(final EntityName entityName) {
        Optional<EntitySequences> sequence = entitySequencesRepository.findByEntityName(entityName);

        if (!sequence.isPresent()) {
            throw new RuntimeException("Entity Sequence is not exist: " + entityName.toString());
        }

        entitySequencesRepository.save(sequence.get().nextValObject());
        return sequence.get().getNextVal();
    }

    private String getHeader(final EntityName entitySequenceNam) {
        String header = "";
        switch (entitySequenceNam) {
            case BOOKING:
                header = "BK";
                break;
        }

        return header;
    }



    @Autowired
    public void setEntitySequencesRepository(EntitySequencesRepository entitySequencesRepository) {
        this.entitySequencesRepository = entitySequencesRepository;
    }





}
