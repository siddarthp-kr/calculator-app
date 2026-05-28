package com.example.backend.service;
import com.example.backend.model.CalculationRequest;
import java.lang.Math;

@Service
public class CalculatorService {
    
    public CalculatorService(){
    }

    private String performCalculation(CalculationRequest calculation){
        String[] calcArr = parseCalculationToStrings(calculation.getProblem());
        double num1 = Double.parseDouble(calcArr[0]);
        double num2 = Double.parseDouble(calcArr[2]);
        String operation = calcArr[1];
        double solution;

        
        switch(operation){
            case "+":
                solution = num1 + num2;
                break;
            case "-":
                solution = num1 - num2;
                break;
            case "*":
                solution = num1 * num2;
                break;
            case "/":
                solution = num1 / num2;
                break;
        }
        calcArr[3] = roundOffAndStringifySolution(solution);


        sendCalculationToDB(calcArr);

        return solution;
        
    }

    //sends stuff to the repository layer, returns a boolean true if successful.
    private boolean sendCalculationToDB(String[] calcArr){

    }

    //Converts a string of the whole calculation into a string array: ["num1", "operation", "num2", ""];
    private String[] parseCalculationToStrings(String calculation){
        //put negative numbers in parentheses, too
    }

    //Rounds the solution to 8 decimal places if necessary
    private String roundOffAndStringifySolution(double number){
        Double roundedNumber = Math.round(number * 100000) / 100000;
        String numStr = roundedNumber.toString();
        return numStr;
    }
}
