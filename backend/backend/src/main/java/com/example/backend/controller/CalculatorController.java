//Handles HTTP Rest API Requestsd
package com.example.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:4200/")
public class CalculatorController {
    //Read only 
    //ClaculatorService: reference business logic
    //calculatorService: calling methods from the service
    private final CalculatorService calculatorService;
    @PostMapping("/calcuate")
    public Calculate 
}