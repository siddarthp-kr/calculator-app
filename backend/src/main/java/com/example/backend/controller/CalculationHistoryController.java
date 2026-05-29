package com.example.backend.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.backend.model.CalculationHistoryRequest;
import com.example.backend.model.CalculationHistoryResponse;
import com.example.backend.service.CalculationHistoryService;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:4200/")
public class CalculationHistoryController {

    private final CalculationHistoryService calculationHistoryService;

    public CalculationHistoryController(CalculationHistoryService calculationHistoryService){
        this.calculationHistoryService = calculationHistoryService;
    }
    
    //maybe return a POJO instead of a List?

    @RequestBody
    @GetMapping(value = "/history")
    public CalculationHistoryResponse getListOfCalculations(CalculationHistoryRequest calculationHistoryRequest){
        CalculationHistoryResponse calculationHistoryResponse = this.calculationHistoryService.getListOfCalculationsFromDB(calculationHistoryRequest);

        return calculationHistoryResponse;
    }
}
