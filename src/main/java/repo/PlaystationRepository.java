package repo;

import controllers.Playstation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaystationRepository extends JpaRepository<Playstation, Long> {
}
