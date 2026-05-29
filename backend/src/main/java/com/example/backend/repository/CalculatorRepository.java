package com.example.backend.repository;

import com.example.backend.model.Calculation;

public interface CalculatorRepository {
    int save(Calculation calculation);    
}
