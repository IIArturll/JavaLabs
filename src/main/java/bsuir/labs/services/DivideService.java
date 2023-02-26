package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.dao.memory.Storage;
import bsuir.labs.services.api.IDivide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DivideService implements IDivide {
    private static final Logger logger = LoggerFactory.getLogger(DivideService.class);
    @Autowired
    private Storage storage;

    @Override
    public ResultDTO get(InputDTO inputDTO) {
        logger.info("enter in divide service method get");
        Double divisible = inputDTO.getDivisible();
        Double divisor = inputDTO.getDivisor();
        Long total = (long) (divisible / divisor);
        Long remains = (long) (divisible % divisor);
        logger.info("Return resultDTO");
        return new ResultDTO(total, remains);
    }

    @Override
    public void save(InputDTO inputDTO) {
        logger.info("enter in divide service save method ");
        storage.save(inputDTO, get(inputDTO));
    }

    @Override
    public List<SourceAndResultDTO> getAll() {
        return storage.getAll().entrySet().stream().
                map((entry) ->
                        new SourceAndResultDTO(
                                entry.getKey().getDivisible(),
                                entry.getKey().getDivisor(),
                                entry.getValue().getTotal(),
                                entry.getValue().getRemains()))
                .toList();
    }
}
