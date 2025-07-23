package asembly.app.service;

import asembly.app.entity.User;
import asembly.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RedisService redisService;

    @CachePut(key = "#user.id", value = "users")
    public ResponseEntity<User> create(User user)
    {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Cacheable(key = "#user", value = "users")
    public ResponseEntity<Iterable<User>> findAll()
    {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @Cacheable(key = "#id", value = "users")
    public ResponseEntity<User> findById(UUID id)
    {
        return ResponseEntity.ok(userRepository.findById(id).orElseThrow());
    }

    public ResponseEntity<String> sendMessage()
    {
        return ResponseEntity.ok("Hello User!!!");
    }
}
