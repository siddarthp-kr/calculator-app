//Handles HTTP Rest API Requestsd
package com.example.backend.controller;

import com.example.backend.entity.Calculation;
import com.example.backend.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.repsonses.ApiResponse;
import io.swagger.v3.oas.annotations.repsonses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;





import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
@Controller
@RequestMapping("/api/calculator")
//@CrossOrigin(origins = "http://localhost:4200/")
public class CalculatorController {
    //Read only 
    //ClaculatorService: reference business logic
    //calculatorService: calling methods from the service
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService service){
        this.service = service;
    }

    @Operation(description = "CALCULATOR getOperationCount API : fetch operation usage")
    @ApiResponses(value = {
        @ApiResponses(responseCode = "200", description = "Success"),
        @ApiResponses(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponses(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })

    @ResponseBody
}