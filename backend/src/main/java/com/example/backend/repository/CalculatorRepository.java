package com.example.backend.repository;

import com.example.backend.model.Calculation;
import java.util.List;

public interface CalculatorRepository {
    int save(Calculation calculation);
    List<Calculation> historyPagination(int page, int size);
    
}
