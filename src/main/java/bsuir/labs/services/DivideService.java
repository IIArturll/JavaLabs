package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.dao.memory.api.ICounter;
import bsuir.labs.dao.memory.api.IStorage;
import bsuir.labs.services.api.IDivide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivideService implements IDivide {
    private static final Logger logger = LoggerFactory.getLogger(DivideService.class);
    @Autowired
    private IStorage storage;

    @Autowired
    private ICounter counter;
    @Override
    public ResultDTO get(InputDTO inputDTO) {
        logger.info("enter in divide service method get");
        counter.increment();
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
        counter.increment();
        storage.save(inputDTO, get(inputDTO));
    }

    @Override
    public List<SourceAndResultDTO> getAll() {
        logger.info("enter in divide service getAll method");
        counter.increment();
        return storage.getAll().entrySet().stream().
                map((entry) ->
                        new SourceAndResultDTO(
                                entry.getKey().getDivisible(),
                                entry.getKey().getDivisor(),
                                entry.getValue().getTotal(),
                                entry.getValue().getRemains()))
                .toList();
    }

    @Override
    public Long getCount() {
        return counter.getCount();
    }
}
