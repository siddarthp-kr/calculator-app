package com.example.backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@ToString


public class Calculation {
    private int id;
    private double num1;
    private double num2;
    private String operation;
    private double result;
    
}
