import { Component } from '@angular/core';

@Component({
    selector: 'history-page',
    template: `
    <h2>Calculation History</h2>
    <h5>These are the last {{tempCalculationHistory.length}} calculations</h5>
    <table>
        @for(calc of tempCalculationHistory; track calc.id){
            
            <tr>
                <td>{{calc.first}}</td> 
                <td>{{calc.operator}}</td> 
                <td>{{calc.second}}</td> 
                <td>=</td>
                <td>{{calc.solution}}</td>
            </tr>
        }
    </table>
    `,
    styleUrl: 'global_styles.css'
})
export class HistoryPage {
    tempCalculationHistory = [
        {id: "1", first: "5", operator: "+", second: "6", solution: "11"},
        {id: "2", first: "6", operator: "*", second: "12", solution: "72"},
        {id: "3", first: "52", operator: "-", second: "16", solution: "36"}
    ]
}