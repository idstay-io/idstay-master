package idstay.backoffice.config.crew.support;


import idstay.backoffice.config.crew.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CrewRepository extends JpaRepository<Crew, Long> {
    Crew findByCrewName(String crewName);

    @Query("SELECT c FROM Crew c WHERE c.activate = true")
    List<Crew> findAllCrews();
}