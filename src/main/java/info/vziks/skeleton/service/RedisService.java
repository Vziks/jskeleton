package info.vziks.skeleton.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisService {

    @Value("${redis.app.prefix}")
    private String prefix;

    @Value("${redis.app.host}")
    private String host;

    @Value("${redis.app.port}")
    private int port;

    @Value("${redis.app.timeout}")
    private int timeout;

    private Jedis jedis;

    public RedisService() {
        this.jedis = new Jedis(host, port, timeout);
    }

    public void set(String key){

    }


}
