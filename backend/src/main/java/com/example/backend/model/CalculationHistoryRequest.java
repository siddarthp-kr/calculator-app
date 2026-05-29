package com.example.backend.model;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class CalculationHistoryRequest {
    private int page;
    private int size;

    public CalculationHistoryRequest(int page, int size){
        this.page = page;
        this.size = size;
    }
}
