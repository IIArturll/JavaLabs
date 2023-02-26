package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.dao.database.entity.SourceAndResultEntity;
import bsuir.labs.dao.database.repository.IStorageRepository;
import bsuir.labs.dao.memory.api.ICounter;
import bsuir.labs.dao.memory.api.IStorage;
import bsuir.labs.services.api.IDivide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DivideService implements IDivide {
    private static final Logger logger = LoggerFactory.getLogger(DivideService.class);
    @Autowired
    private IStorage storage;

    @Autowired
    private IStorageRepository repository;
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
        logger.info("Return ResultDTO");
        return new ResultDTO(total, remains);
    }

    @Override
    public void save(InputDTO inputDTO) {
        logger.info("enter in divide service save method ");
        counter.increment();
        //storage.save(inputDTO, get(inputDTO)); //memory
        logger.info("save in data base value");
        repository.save(new SourceAndResultEntity(inputDTO, get(inputDTO))); //db
    }

    @Override
    public List<SourceAndResultDTO> getAll() {
        logger.info("enter in divide service getAll method");
        counter.increment();
        logger.info("Return List<ResultDTO>");
//        return storage.getAll().entrySet().stream().
//                map((entry) ->
//                        new SourceAndResultDTO(
//                                entry.getKey().getDivisible(),
//                                entry.getKey().getDivisor(),
//                                entry.getValue().getTotal(),
//                                entry.getValue().getRemains()))
//                .toList();
        List<SourceAndResultDTO> list=new ArrayList<>();
        logger.info("read from data base");
        repository.findAll().forEach(entity -> list.add(new SourceAndResultDTO(
                entity.getInputDTO(),entity.getResultDTO())));
        return list;
    }

    @Override
    public void saveAll(List<InputDTO> list) {
        logger.info("enter in divide service saveAll method");
        counter.increment();
//        Map<InputDTO, ResultDTO> map = new HashMap<>();
//        list.forEach(dto -> map.put(
//                new InputDTO(dto.getDivisible(), dto.getDivisor()),
//                get(dto)));
//        storage.saveAll(map);
        List<SourceAndResultEntity> entities = list.stream().map(SourceAndResultEntity::new).toList();
        logger.info("save list of values in data base");
        repository.saveAll(entities);
    }

    @Override
    public Long getCount() {
        return counter.getCount();
    }
}
