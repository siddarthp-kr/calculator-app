package com.example.backend.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.example.backend.model.Calculation;
import com.example.backend.model.CalculationHistoryRequest;

@Service
public class CalculationHistoryService {
    public List<Calculation> getListOfCalculationsFromDB(CalculationHistoryRequest request){
        List<Calculation> listOfCalculations = new ArrayList<>();

        return listOfCalculations;
    }
}
