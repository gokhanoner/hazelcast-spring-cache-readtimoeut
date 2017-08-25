package com.example.hazelcastspringcachetimeout;

import com.hazelcast.core.OperationTimeoutException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class DummyCacheService {

    @Retryable(value = { OperationTimeoutException.class}, maxAttempts = 1, backoff = @Backoff(delay = 100))
    @Cacheable(value = "test", sync = true)
    public String getValue(int id) {
        return id + "";
    }

    @Recover
    public String recoverGetValue(OperationTimeoutException e, int id) {
        System.out.println("getting data from different resource");
        return id + "";
    }
}
