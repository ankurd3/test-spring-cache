package com.test.cache.testspringcache.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.cache.testspringcache.struct.EncounterAttr;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
@Slf4j
public class JsonRepository {

    private static final String path = "src/main/resources/encounter-attributes.json";

    public Optional<EncounterAttr> getEncounterAttr(String type){
        List<EncounterAttr> encounterAttrList = load.andThen(from).apply(JsonRepository.path);

        return filter.apply(type, encounterAttrList);
    }

    Function<String, String> load = path -> {
        File initialFile = new File(path);
        InputStream targetStream = null;
        String json = null;
        try {
            targetStream = FileUtils.openInputStream(initialFile);
            json = IOUtils.toString(targetStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    };

    Function<String, List<EncounterAttr>> from = str -> {
        ObjectMapper mapper = new ObjectMapper();
        List<EncounterAttr> encounterAttr = null;
        try {
            encounterAttr = mapper.readValue(str, new TypeReference<List<EncounterAttr>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encounterAttr;
    };

    BiFunction<String, List<EncounterAttr>, Optional<EncounterAttr>> filter = (type, encounterAttrList) -> {
        return encounterAttrList.stream()
                .filter(attr -> type.equals(attr.getType()))
                .findAny();
    };
}
