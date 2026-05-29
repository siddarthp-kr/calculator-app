package com.example.backend.model;

public class CalculationRequest {

    private double num1;
    private double num2;
    private String operation;

    //getters
    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    //setters
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}