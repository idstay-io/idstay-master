package idstay.hotel.member;

import java.util.List;

import idstay.hotel.member.support.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewService {
    private CrewRepository crewRepository;

    public Crew save(Crew crew) {
        Crew crew_ = crewRepository.findByCrewName(crew.getCrewName());
        if (crew_ != null) throw new RuntimeException();
        return crewRepository.save(crew);
    }

    public Crew findByCrewName(String crewName) {
        Crew crew = crewRepository.findByCrewName(crewName);
        if(crew == null) throw new RuntimeException("crew find by crewName Error: '" + crewName + "'");
        return crew;
    }

    public List<Crew> getAllCrews() {
        return (List<Crew>)crewRepository.findAllCrews();
    }

    @Autowired
    public void setCrewRepository(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }
}
