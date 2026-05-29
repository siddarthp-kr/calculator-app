package com.example.backend.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.backend.model.Calculation;
import com.example.backend.model.CalculationHistoryRequest;
import com.example.backend.model.CalculationHistoryResponse;
import com.example.backend.repository.CalculationHistoryRepository;

@Service
public class CalculationHistoryService {

    private final CalculationHistoryRepository calculationHistoryRepository;

    public CalculationHistoryService(CalculationHistoryRepository calculationHistoryRepository){
        this.calculationHistoryRepository = calculationHistoryRepository;
    }

    public CalculationHistoryResponse getListOfCalculationsFromDB(CalculationHistoryRequest request){
        List<Calculation> listOfCalculations = this.calculationHistoryRepository.getListOfCalculations(request);
        return new CalculationHistoryResponse(listOfCalculations);
    }
}
