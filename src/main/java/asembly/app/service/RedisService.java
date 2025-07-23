package asembly.app.service;

import asembly.app.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, User> redisTemplate;

    public void setValue(String key, User value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    public User getValue(String key)
    {
        return redisTemplate.opsForValue().get(key);
    }

}
