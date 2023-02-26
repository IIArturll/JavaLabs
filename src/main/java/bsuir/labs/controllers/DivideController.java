package bsuir.labs.controllers;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.core.dtos.SourceAndResultDTO;
import bsuir.labs.services.api.IDivide;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/divide")
public class DivideController {
    private final IDivide service;
    private static final Logger logger = LoggerFactory.getLogger(DivideController.class);

    public DivideController(IDivide service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<ResultDTO> get(@Valid @RequestBody InputDTO inputDTO) {
        logger.info("enter in get point");
        return ResponseEntity.status(200).body(service.get(inputDTO));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody InputDTO inputDTO) {
        logger.info("enter in post pint save");
        service.save(inputDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<SourceAndResultDTO>> getAll() {
        logger.info("enter in get point get all");
        return ResponseEntity.status(200).body(service.getAll());
    }

}