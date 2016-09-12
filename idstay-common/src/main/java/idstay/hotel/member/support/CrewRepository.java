package idstay.hotel.member.support;

import idstay.hotel.member.Crew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrewRepository extends CrudRepository<Crew, Long> {
    Crew findByCrewName(String crewName);
    @Query("SELECT c FROM Crew c WHERE c.activate = true")
    List<Crew> findAllCrews();
}