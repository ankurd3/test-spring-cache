package com.test.cache.testspringcache.service;

import com.test.cache.testspringcache.json.JsonRepository;
import com.test.cache.testspringcache.struct.EncounterAttr;
import com.test.cache.testspringcache.struct.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EncounterService {
    private JsonRepository jsonRepository;

    @Autowired
    public EncounterService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    @Cacheable(value = "attributes")
    public Optional<EncounterAttr> getEncounterAttr(String type){
        log.info("In Service");
        return jsonRepository.getEncounterAttr(type);
    }


    public List getValues(){
        log.info("In Service all values");
        return Test.getList();
    }

    @Cacheable(value = "value", key = "#p0")
    public int get(int index){
        log.info("In Service get");
        return Test.get(index);
    }

    @CachePut(value = "value", key = "#p0")
    public int add(int index, int value){
        log.info("In Service add");
        return Test.add(index, value);
    }

    @CacheEvict(value = "value", key = "#p0")
    public boolean remove(int index){
        log.info("In Service remove");
        return Test.remove(index);
    }

    @CacheEvict(cacheNames = {"value"}, key = "#p0")
    public boolean cacheEvict(int cacheIndex) {
        log.info("Evicting for index : "+ cacheIndex);
        return true;
    }
}
