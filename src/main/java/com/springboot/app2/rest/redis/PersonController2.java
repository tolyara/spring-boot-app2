package com.springboot.app2.rest.redis;

import com.springboot.app2.dto.redis.PersonDto;
import com.springboot.app2.dto.redis.RangeDto;
import com.springboot.app2.service.redis.RedisListCache;
import com.springboot.app2.service.redis.RedisValueCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person2")
public class PersonController2 {

    private final RedisValueCache valueCache;
    private final RedisListCache listCache;

    @Autowired
    public PersonController2(final RedisValueCache valueCache, final RedisListCache listCache) {
        this.valueCache = valueCache;
        this.listCache = listCache;
    }

    @PostMapping
    public void cachePerson(@RequestBody final PersonDto dto) {
        valueCache.cache(dto.getId(), dto);
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable final String id) {
        return (PersonDto) valueCache.getCachedValue(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable final String id) {
        valueCache.deleteCachedValue(id);
    }

    @PostMapping("/list/{key}")
    public void cachePersons(@PathVariable final String key, @RequestBody final List<PersonDto> persons) {
        listCache.cachePersons(key, persons);
    }

    @GetMapping("/list/{key}")
    public List<PersonDto> getPersonsInRange(@PathVariable final String key, @RequestBody final RangeDto range) {
        return listCache.getPersonsInRange(key, range);
    }

    /*
        gets last element AND REMOVES IT
     */
    @GetMapping("/list/last/{key}")
    public PersonDto getLastElement(@PathVariable final String key) {
        return listCache.getLastElement(key);
    }

    @DeleteMapping("/list/{key}")
    public void trim(@PathVariable final String key, @RequestBody final RangeDto range) {
        listCache.trim(key, range);
    }

}
