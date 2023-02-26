package bsuir.labs.dao.memory;

import bsuir.labs.dao.memory.api.ICounter;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class RequestCounter implements ICounter {
    private final AtomicLong count = new AtomicLong();

    @Override
    public void increment() {
        synchronized (RequestCounter.class) {
            count.incrementAndGet();
        }
    }

    @Override
    public Long getCount() {
        return count.get();
    }
}
