package com.anas.singleton;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.concurrent.*;
import org.junit.jupiter.api.Test;

class SingletonTest {

    @Test
    void holderReturnsSameInstance() {
        assertSame(HolderSingleton.getInstance(), HolderSingleton.getInstance());
    }

    @Test
    void holderIsThreadSafe() throws Exception {
        var pool = Executors.newFixedThreadPool(50);
        Set<HolderSingleton> instances = ConcurrentHashMap.newKeySet();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(pool.submit(() -> instances.add(HolderSingleton.getInstance())));
        }
        for (var f : futures) f.get();
        pool.shutdown();
        assertEquals(1, instances.size());
    }
}