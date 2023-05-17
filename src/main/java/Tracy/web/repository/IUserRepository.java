package Tracy.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Tracy.web.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}