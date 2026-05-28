//Handles HTTP Rest API Requestsd
package com.example.backend.controller;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.backend.entity.Calculation;
//import com.example.backend.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.backend.model.CalculationResponse;
import com.example.backend.model.CalculationRequest;
import com.example.backend.service.CalculatorService;


import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:4200/")
public class CalculatorController {
    //Read only 
    //CalculatorService: reference business logic
    //calculatorService: calling methods from the service
    private final CalculatorService calculatorService = new CalculatorService();

    // public CalculatorController(CalculatorService service){
    //     this.calculatorService = service;
    // }

    @Operation(description = "CALCULATOR getOperationCount API : fetch operation usage")
    // @ApiResponses(value = {
    //     @ApiResponse(responseCode = "200", description = "Success"),
    //     @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //     @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    // })

    @ResponseBody
    @PostMapping(value = "/calculation" /*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    
    
    public String handleCalculation(@RequestBody CalculationRequest calculation){
        String solution = "ERROR";
        if(calculationIsValid(calculation)){
            solution = calculatorService.performCalculation(calculation);
        } else {
            solution = "ERROR";
        }
        
        return solution;
    }

    //finish this method to determine the validity of the calculation sent
    //Check that all the parts are there, not dividing by 0
    private boolean calculationIsValid(CalculationRequest calculation){
        boolean isValid = false;

        return isValid;
    }
    
}