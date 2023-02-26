package bsuir.labs.services;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.exceptions.SingleErrorResponse;
import bsuir.labs.services.api.IStatisticService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class StatisticService implements IStatisticService {

    @Override
    public SourceAndResultDTO findMinRes(List<InputDTO> list) throws SingleErrorResponse {
        return list.stream().map(SourceAndResultDTO::new)
                .min(new ResultComparator())
                .orElseThrow(() -> new SingleErrorResponse("err", "list empty"));

    }

    @Override
    public SourceAndResultDTO findMaxRes(List<InputDTO> list) throws SingleErrorResponse {
        return list.stream().map(SourceAndResultDTO::new)
                .max(new ResultComparator())
                .orElseThrow(() -> new SingleErrorResponse("err", "list empty"));
    }

    @Override
    public SourceAndResultDTO findMiddleRes(List<InputDTO> list) throws SingleErrorResponse {
        return list.stream().map(SourceAndResultDTO::new)
                .sorted(new ResultComparator())
                .skip(list.size() / 2)
                .findFirst()
                .orElseThrow(() -> new SingleErrorResponse("err", "list empty"));
    }

    class ResultComparator implements Comparator<SourceAndResultDTO> {
        @Override
        public int compare(SourceAndResultDTO o1, SourceAndResultDTO o2) {
            if (o1.getTotal().compareTo(o2.getTotal()) == 0) {
                return o1.getRemains().compareTo(o2.getRemains());
            } else {
                return o1.getTotal().compareTo(o2.getTotal());
            }
        }
    }

}
