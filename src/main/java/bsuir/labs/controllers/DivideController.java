package bsuir.labs.controllers;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.services.api.IDivide;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/divide")
public class DivideController {
    private final IDivide service;
    private static final Logger logger = LoggerFactory.getLogger(DivideController.class);

    public DivideController(IDivide service) {
        this.service = service;
    }

    @GetMapping()
    public ResultDTO get(@Valid @RequestBody InputDTO inputDTO) {
        logger.info("enter in get point");
        return service.get(inputDTO);
    }

}