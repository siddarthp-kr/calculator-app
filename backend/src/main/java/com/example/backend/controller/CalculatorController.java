//Handles HTTP Rest API Requests
package com.example.backend.controller;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.ErrorResponse;

import com.example.backend.model.CalculationRequest;
import com.example.backend.service.CalculatorService;


@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:4200/")
public class CalculatorController {
    //Read only 
    //CalculatorService: reference business logic
    //calculatorService: calling methods from the service


    //private final CalculatorService calculatorService = new CalculatorService();
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Operation(description = "CALCULATOR getOperationCount API : fetch operation usage")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })

    @ResponseBody
    @PostMapping(value = "/calculation")
    
    
    public String handleCalculation(@RequestBody CalculationRequest calculation){
            return calculatorService.performCalculation(calculation);
    }


    
}