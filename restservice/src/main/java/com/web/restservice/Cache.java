package com.web.restservice;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;


@Component

public class Cache {
    private final ConcurrentHashMap<SearchingNumbers, Search> hashMap = new ConcurrentHashMap<>();

    public synchronized void put(SearchingNumbers vectorBody, Search vector) {
        hashMap.put(vectorBody, vector);
    }

    public synchronized boolean isContains(SearchingNumbers vectorBody) {
        return hashMap.containsKey(vectorBody);
    }

    public synchronized Search get(SearchingNumbers vectorBody) {
        return hashMap.get(vectorBody);
    }


}
