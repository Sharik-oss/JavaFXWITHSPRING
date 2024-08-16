package repo;

import model.Hookah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HookahRepository extends JpaRepository<Hookah, Long> {
    void deletePlaystationById(Long id);

    Hookah findHookahById(Long id);
}
