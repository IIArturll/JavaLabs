package bsuir.labs.controllers;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.exceptions.SingleErrorResponse;
import bsuir.labs.services.api.IStatisticService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stat")
public class StatisticController {

    @Autowired
    private IStatisticService service;

    @GetMapping(value = "/min")
    public ResponseEntity<SourceAndResultDTO> getMin(@Valid @RequestBody List<InputDTO> list)
            throws SingleErrorResponse {
        return ResponseEntity.status(200).body(service.findMinRes(list));
    }

    @GetMapping(value = "/max")
    public ResponseEntity<SourceAndResultDTO> getMax(@Valid @RequestBody List<InputDTO> list)
            throws SingleErrorResponse {
        return ResponseEntity.status(200).body(service.findMaxRes(list));
    }

    @GetMapping(value = "/middle")
    public ResponseEntity<SourceAndResultDTO> getMiddle(@Valid @RequestBody List<InputDTO> list)
            throws SingleErrorResponse {
        return ResponseEntity.status(200).body(service.findMiddleRes(list));
    }

}
