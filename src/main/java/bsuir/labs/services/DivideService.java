package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.services.api.IDivide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DivideService implements IDivide {
    private static final Logger logger = LoggerFactory.getLogger(DivideService.class);

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
}
