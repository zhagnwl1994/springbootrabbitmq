package comm.springboot.redis.springbootredis.ImpServices;

import comm.springboot.redis.springbootredis.IServices.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ImplHelloService implements IHelloService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    @PostMapping(name = "/hello")
    public void hello() {
        stringRedisTemplate.opsForValue().set("a","abc");
    }
}
