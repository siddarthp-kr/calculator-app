package com.example.backend.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;
import com.example.backend.model.Calculation;
import com.example.backend.model.CalculationHistoryRequest;
import com.example.backend.service.CalculationHistoryService;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:4200/")
public class CalculationHistoryController {

    private final CalculationHistoryService calculationHistoryService;

    public CalculationHistoryController(CalculationHistoryService calculationHistoryService){
        this.calculationHistoryService = calculationHistoryService;
    }
    
    @RequestBody
    @GetMapping(value = "/history")
    public List<Calculation> getListOfCalculations(CalculationHistoryRequest request){
        List<Calculation> result = new ArrayList<>();

        return result;
    }
}
