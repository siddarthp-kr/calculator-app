package com.example.backend.model;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import java.util.Comparator;

@Getter
@Setter
public class CalculationHistoryResponse {
    private List<Calculation> calculations;

    public CalculationHistoryResponse(List<Calculation> calculations){
        this.calculations = calculations;
        //this sorts the list so that the History page lists calculations in reverse chronological order
        this.calculations.sort(new CalculationComparator());
    }

    public class CalculationComparator implements Comparator<Calculation> {
        @Override
        public int compare(Calculation a, Calculation b){
            int result = 0;
            if(a.getId() > b.getId()){
                result = -1;
            } else if(b.getId() > a.getId()) {
                result = 1;
            }
            return result;
        }
    }
}
