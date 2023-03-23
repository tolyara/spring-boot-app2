package com.springboot.app2.service.redis;

import com.springboot.app2.util.LoggingUtil;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisListCache {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RedisTemplate<String, Object> redisTemplate;
    private ListOperations<String, Object> listOperations;

    public RedisListCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.listOperations = redisTemplate.opsForList();
    }

    @PostConstruct
    public void setup() {
        listOperations.leftPush("key", "Hello there from Redis");
        logger.info("{} {}", LoggingUtil.APP, listOperations.rightPop("key"));
    }

}
