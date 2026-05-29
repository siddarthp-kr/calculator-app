package com.example.backend.service;
import java.lang.Math;
import org.springframework.stereotype.Service;
import com.example.backend.model.CalculationRequest;
import com.example.backend.model.Calculation;
import com.example.backend.repository.CalculatorRepositoryImpl;

@Service
public class CalculatorService {
    
    private final CalculatorRepositoryImpl calculatorRepository;
    public CalculatorService(CalculatorRepositoryImpl calculatorRepository){
        this.calculatorRepository = calculatorRepository;
    }

    public String performCalculation(CalculationRequest request) {
        double num1 = request.getNum1();
        double num2 = request.getNum2();
        String operation = request.getOperation();
        double solution = 0;

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

         sendCalculationToDB(request, solution);

         return roundOffAndStringifySolution(solution);
    }

    // public String performCalculation(String calculation){
    //     String[] calcArr = parseCalculationToStrings(calculation);
    //     double num1 = Double.parseDouble(calcArr[0]);
    //     double num2 = Double.parseDouble(calcArr[2]);
    //     String operation = calcArr[1];
    //     double solution = 0;

        
    //     switch(operation){
    //         case "+":
    //             solution = num1 + num2;
    //             break;
    //         case "-":
    //             solution = num1 - num2;
    //             break;
    //         case "*":
    //             solution = num1 * num2;
    //             break;
    //         case "/":
    //             solution = num1 / num2;
    //             break;
    //     }
    //     calcArr[3] = roundOffAndStringifySolution(solution);


    //     sendCalculationToDB(calcArr);

    //     return ((Double)solution).toString();
        
    // }

    //sends stuff to the repository layer, returns a boolean true if successful.
    private boolean sendCalculationToDB(CalculationRequest request, double solution){
        //fill this in
        boolean result = false;

        Calculation calculation = new Calculation();
        calculation.setNum1(request.getNum1());
        calculation.setNum2(request.getNum2());
        calculation.setOperation(request.getOperation());
        calculation.setResult(solution);

        result = this.calculatorRepository.save(calculation) == 1;

        return result;
    }

    //Converts a string of the whole calculation into a string array: ["num1", "operation", "num2", ""];
    private String[] parseCalculationToStrings(String calculation){
        String[] parsedCalculationArr = new String[4];
        int operationIndex = 0;
        boolean isJustNumber = false;
        String num1 = "", num2 = "", operation = "";
        if(calculation.indexOf("+") >= 0){
            operationIndex = calculation.indexOf("+");

        } else if(calculation.indexOf("*") >= 0){
            operationIndex = calculation.indexOf("*");
           
        } else if(calculation.indexOf("/") >= 0){
            operationIndex = calculation.indexOf("/");
        
        } else if(calculation.indexOf("-") >= 0){
            operationIndex = calculation.indexOf("-");
            //put different code here for negatives vs subtraction
            int secondMinusSignIndex = calculation.indexOf("-", operationIndex + 1);
            if(secondMinusSignIndex >= 0){
                int thirdMinusSignIndex = calculation.indexOf("-", secondMinusSignIndex + 1);
                if(thirdMinusSignIndex >= 0){
                    operationIndex = secondMinusSignIndex;
                } else {
                    if(operationIndex == 0){
                        operationIndex = secondMinusSignIndex;
                    }
                }
                
            }
        } else {
            isJustNumber = true;
        }

        if(!isJustNumber){
            num1 = calculation.substring(0, operationIndex);
            num2 = calculation.substring(operationIndex + 1);
            operation = calculation.substring(operationIndex, operationIndex + 1);
        } else {
            num1 = calculation;
            operation = "+";
            num2 = "0";
        }

        parsedCalculationArr[0] = num1;
        parsedCalculationArr[1] = operation;
        parsedCalculationArr[2] = num2;
        
        return parsedCalculationArr;
    }

    //Rounds the solution to 8 decimal places if necessary
    private String roundOffAndStringifySolution(double number){
        double roundedNumber = /*(Math.round(number * 1000000000) + 0.0) / 1000000000*/ number;
        String numStr = "";

        //get rid of decimal pt if the solution is an integer
        if(roundedNumber - Math.floor(roundedNumber) <= 0.00000001){
            numStr = ((int) roundedNumber) + "";
        } else {
            numStr = roundedNumber + "";
        }

        

        return numStr;
    }

}
