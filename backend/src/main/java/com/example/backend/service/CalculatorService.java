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
        String[] parsedCalculationArr = new String[4];
        if(calculation.indexOf("+") >= 0){
            int operationIndex = calculation.indexOf("+");
            String num1 = calculation.substring(0, operationIndex);
            String num2 = calculation.substring(operationIndex + 1);
            String operation = calculation.substring(operationIndex, operationIndex + 1);
            parsedCalculationArr[0] = num1;
            parsedCalculationArr[1] = operation;
            parsedCalculationArr[2] = num2;

        } else if(calculation.indexOf("*") >= 0){
            int operationIndex = calculation.indexOf("*");
            String num1 = calculation.substring(0, operationIndex);
            String num2 = calculation.substring(operationIndex + 1);
            String operation = calculation.substring(operationIndex, operationIndex + 1);
            parsedCalculationArr[0] = num1;
            parsedCalculationArr[1] = operation;
            parsedCalculationArr[2] = num2;

        } else if(calculation.indexOf("/") >= 0){
            int operationIndex = calculation.indexOf("/");
            String num1 = calculation.substring(0, operationIndex);
            String num2 = calculation.substring(operationIndex + 1);
            String operation = calculation.substring(operationIndex, operationIndex + 1);
            parsedCalculationArr[0] = num1;
            parsedCalculationArr[1] = operation;
            parsedCalculationArr[2] = num2;

        } else if(calculation.indexOf("-") >= 0){
            int operationIndex = calculation.indexOf("-");
            //put different code here for negatives vs subtraction
            String afterFirstMinusSignStr = calculation.substring(operationIndex + 1);

            if(afterFirstMinusSignStr.indexOf("-") >= 0){
                int secondMinusSignIndex = afterFirstMinusSignStr.indexOf("-");
                if(secondMinusSignIndex >= 0){
                    String afterSecondMinusSignStr = afterFirstMinusSignStr.substring(secondMinusSignIndex + 1);
                    int thirdMinusSignIndex = afterSecondMinusSignStr.indexOf("-");
                    if(thirdMinusSignIndex >= 0){
                        operationIndex = secondMinusSignIndex;
                    } else {
                        //check here which minus sign is the correct one
                    }
                }
            }
            

        } else {
            //Put error message here
        }
        
        return parsedCalculationArr;
    }

    //Rounds the solution to 8 decimal places if necessary
    private String roundOffAndStringifySolution(double number){
        Double roundedNumber = Math.round(number * 100000) / 100000;
        String numStr = roundedNumber.toString();

        //add code to get rid of decimal pt if the solution is an integer

        return numStr;
    }
}
