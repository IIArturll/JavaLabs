package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.exceptions.SingleErrorResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StatisticServiceTest {

    @Test
    void testFindMin() throws SingleErrorResponse {
        List<InputDTO> list = List.of(
                new InputDTO(10.0, 2.0),
                new InputDTO(5.0, 2.0),
                new InputDTO(15.0, 5.0));
        StatisticService statisticService = new StatisticService();

        SourceAndResultDTO min = statisticService.findMinRes(list);

        Assertions.assertEquals(min.getResult(),new ResultDTO(2L,1L));
    }

    @Test
    void testFindMax() throws SingleErrorResponse {
        List<InputDTO> list = List.of(
                new InputDTO(10.0, 2.0),
                new InputDTO(5.0, 2.0),
                new InputDTO(15.0, 5.0));
        StatisticService statisticService = new StatisticService();
        SourceAndResultDTO max = statisticService.findMaxRes(list);

        Assertions.assertEquals(max.getResult(), new ResultDTO(5L,0L));
    }

    @Test
    void testFindMidl() throws SingleErrorResponse {

        List<InputDTO> list = List.of(
                new InputDTO(10.0, 2.0),
                new InputDTO(5.0, 2.0),
                new InputDTO(15.0, 5.0));
        StatisticService statisticService = new StatisticService();
        SourceAndResultDTO middle = statisticService.findMiddleRes(list);

        Assertions.assertEquals(middle.getResult(), new ResultDTO(3L,0L));
    }

}