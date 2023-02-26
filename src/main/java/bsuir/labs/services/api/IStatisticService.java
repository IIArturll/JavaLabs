package bsuir.labs.services.api;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.exceptions.SingleErrorResponse;

import java.util.List;

public interface IStatisticService {
    SourceAndResultDTO findMinRes(List<InputDTO> list) throws SingleErrorResponse;

    SourceAndResultDTO findMaxRes(List<InputDTO> list) throws SingleErrorResponse;

    SourceAndResultDTO findMiddleRes(List<InputDTO> list) throws SingleErrorResponse;

}
