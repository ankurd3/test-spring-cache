package com.test.cache.testspringcache.struct;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test {
    public static List<Integer> list = new ArrayList();


    public static List getList() {
        log.info("getting entire list");
        return list;
    }

    public static int add(int index, int value){
        log.info("adding");
        list.add(index, value);
        return value;
    }

    public static boolean remove(int i) {
        log.info("removing");
        list.remove(i);
        return true;
    }

    public static int get(int index) {
        log.info("getting");
        return list.get(index);
    }
}
