package com.test.cache.testspringcache.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attribute {
    private String name;
    private String type;
    private long sort;

    @JsonProperty("copyfromprevious")
    private String copyFromPrevious;

    @JsonProperty("copyfrom")
    private String copyFrom;

    private String normal;

    @JsonProperty("displayvalues")
    private String[] displayValues;
}
