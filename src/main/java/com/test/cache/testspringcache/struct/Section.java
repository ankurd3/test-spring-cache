package com.test.cache.testspringcache.struct;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Section {
    private String type;
    private List<Attribute> attributes;
}
