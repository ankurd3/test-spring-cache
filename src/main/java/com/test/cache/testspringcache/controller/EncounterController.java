package com.test.cache.testspringcache.controller;

import com.test.cache.testspringcache.service.EncounterService;
import com.test.cache.testspringcache.struct.EncounterAttr;
import com.test.cache.testspringcache.struct.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/encounters")
public class EncounterController {

    private EncounterService encounterService;

    @Autowired
    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @GetMapping(value = "/attributes/{type}")
    public ResponseEntity<?> getEncounterAttr(@PathVariable String type){
        log.info("In Controller");
        Optional<EncounterAttr> attr = this.encounterService.getEncounterAttr(type);
        return attr.isPresent() ? new ResponseEntity(attr.get(),HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/values")
    public ResponseEntity<?> getValues(){
        log.info("In get all values Controller");
     return new ResponseEntity(this.encounterService.getValues(),HttpStatus.OK);
    }

    @GetMapping(value = "/get/{index}")
    public ResponseEntity<?> get(@PathVariable int index){
        log.info("In get Controller");
        return new ResponseEntity(this.encounterService.get(index),HttpStatus.OK);
    }

    @GetMapping(value = "/add/{index}/{value}")
    public ResponseEntity<?> add(@PathVariable int index, @PathVariable int value){
        log.info("In add values Controller");
        return new ResponseEntity(this.encounterService.add(index,value),HttpStatus.OK);
    }

    @GetMapping(value = "/remove/{newValue}")
    public ResponseEntity<?> remove(@PathVariable int newValue){
        log.info("In remove values Controller");
        return new ResponseEntity(this.encounterService.remove(newValue),HttpStatus.OK);
    }

    @GetMapping(value = "/evict/{index}")
    public ResponseEntity<?> evict(@PathVariable int index){
        log.info("In remove values Controller");
        return new ResponseEntity(this.encounterService.cacheEvict(index),HttpStatus.OK);
    }
}
