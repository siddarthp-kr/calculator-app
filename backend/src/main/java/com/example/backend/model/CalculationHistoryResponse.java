package com.example.backend.model;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationHistoryResponse {
    private List<Calculation> calculations;

    public CalculationHistoryResponse(List<Calculation> calculations){
        this.calculations = calculations;
    }
}
