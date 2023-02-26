package bsuir.labs.dao.memory;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.dao.memory.api.IStorage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Storage implements IStorage {
    private final Map<InputDTO, ResultDTO> storage;

    public Storage() {
        storage = new ConcurrentHashMap<>();
    }

    @Override
    public void save(InputDTO inputDTO, ResultDTO resultDTO) {
        storage.put(inputDTO, resultDTO);
    }

    @Override
    public Map<InputDTO, ResultDTO> getAll() {
        return Collections.unmodifiableMap(storage);
    }
}
