package bsuir.labs.dao.memory.api;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;

import java.util.Map;

public interface IStorage {
    void save(InputDTO inputDTO, ResultDTO resultDTO);

    Map<InputDTO, ResultDTO> getAll();

    void saveAll(Map<InputDTO,ResultDTO> map);
}
