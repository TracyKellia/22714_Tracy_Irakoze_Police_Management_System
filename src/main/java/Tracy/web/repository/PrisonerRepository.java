package Tracy.web.repository;
import Tracy.web.model.Prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonerRepository extends JpaRepository<Prisoner, Long>{

}
