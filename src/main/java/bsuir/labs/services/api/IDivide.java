package bsuir.labs.services.api;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;

import java.util.List;

public interface IDivide {
    ResultDTO get(InputDTO inputDTO);

    void save(InputDTO inputDTO);

    List<SourceAndResultDTO> getAll();
}

