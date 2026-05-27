package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "calculation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double num1;
    private double num2;
    private String operation;
    private double result;
    
}
