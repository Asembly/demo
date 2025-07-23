package asembly.app.repository;

import asembly.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "select * from users where username = :username", nativeQuery = true)
    public Optional<User> findByUsername(String username);
}
