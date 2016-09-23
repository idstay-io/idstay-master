package idstay.hotelconfig.crew.support;


import idstay.hotelconfig.crew.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrewRepository extends JpaRepository<Crew, Long> {
    Crew findByCrewName(String crewName);

    @Query("SELECT c FROM Crew c WHERE c.activate = true")
    List<Crew> findAllCrews();
}