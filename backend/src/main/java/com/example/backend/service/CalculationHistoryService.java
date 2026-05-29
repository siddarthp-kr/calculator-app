package com.example.backend.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.example.backend.model.Calculation;
import com.example.backend.model.CalculationHistoryRequest;
import com.example.backend.model.CalculationHistoryResponse;

@Service
public class CalculationHistoryService {
    public CalculationHistoryResponse getListOfCalculationsFromDB(CalculationHistoryRequest request){
        List<Calculation> listOfCalculations = new ArrayList<>();

        return new CalculationHistoryResponse(listOfCalculations);
    }
}
