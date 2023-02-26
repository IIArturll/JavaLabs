package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.services.api.IDivide;
import org.springframework.stereotype.Service;

@Service
public class DivideService implements IDivide {

    @Override
    public ResultDTO get(InputDTO inputDTO) {
        Double divisible = inputDTO.getDivisible();
        Double divisor = inputDTO.getDivisor();
        Long total = (long) (divisible / divisor);
        Long remains = (long) (divisible % divisor);
        return new ResultDTO(total, remains);
    }
}
