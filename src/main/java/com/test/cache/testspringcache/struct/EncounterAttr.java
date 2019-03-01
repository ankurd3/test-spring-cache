package com.test.cache.testspringcache.struct;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EncounterAttr {
    private String name;
    private String type;
    private List<Map<String, Object>> sections;
}
