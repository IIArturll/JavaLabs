package bsuir.labs.controllers;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.services.api.IDivide;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/divide")
public class DivideController {
    private final IDivide service;

    public DivideController(IDivide service) {
        this.service = service;
    }

    @GetMapping()
    public ResultDTO get(@RequestBody InputDTO inputDTO) {
        return service.get(inputDTO);
    }

}