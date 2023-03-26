package com.springboot.app2.service.redis;

import com.springboot.app2.dto.redis.PersonDto;
import com.springboot.app2.dto.redis.RangeDto;
import com.springboot.app2.util.LoggingUtil;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedisListCache {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RedisTemplate<String, Object> redisTemplate;
    private ListOperations<String, Object> listOperations;

    public RedisListCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.listOperations = redisTemplate.opsForList();
    }

//    @PostConstruct
    public void setup() {
        listOperations.leftPush("key", "Hello there from Redis");
        logger.info("{} {}", LoggingUtil.APP, listOperations.rightPop("key"));
    }

    // left push ->
    // 5 4 3 2 1
    // 4 3 2 1
    // 3 2 1
    // 2 1
    // 1
    public void cachePersons(String key, List<PersonDto> persons) {
        for (PersonDto person : persons) {
            listOperations.leftPush(key, person);
        }
    }

    public List<PersonDto> getPersonsInRange(String key, RangeDto range) {
        List<Object> objects = listOperations.range(key, range.getFrom(), range.getTo());
        if (CollectionUtils.isEmpty(objects)) {
            return Collections.emptyList();
        }

//        return objects.stream().map(o -> (PersonDto) o).collect(Collectors.toList());
        return objects.stream().collect(Collectors.filtering(o -> o instanceof PersonDto, Collectors.mapping(o -> (PersonDto) o, Collectors.toList())));
    }

    /*
        gets last element AND REMOVES IT
    */
    public PersonDto getLastElement(String key) {
        final Object o = listOperations.rightPop(key);
        return o instanceof PersonDto ? (PersonDto) o : null;
    }

    // 5 4 3 2 1
    // trim (..., 1, 3) -> 4 3 2
    public void trim(String key, RangeDto range) {
        listOperations.trim(key, range.getFrom(), range.getTo());
    }

}
