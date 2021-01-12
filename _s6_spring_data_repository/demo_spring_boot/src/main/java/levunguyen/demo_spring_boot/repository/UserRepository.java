package levunguyen.demo_spring_boot.repository;

import levunguyen.demo_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
