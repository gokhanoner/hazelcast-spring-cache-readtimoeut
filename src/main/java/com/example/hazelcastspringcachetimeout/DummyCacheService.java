package com.example.hazelcastspringcachetimeout;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DummyCacheService {

    @Cacheable("test")
    public String getValue(int id) {
        return id + "";
    }
}
