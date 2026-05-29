import { Component, OnInit, output } from '@angular/core';
import { Api } from '../services/api';
import { ChangeDetectorRef } from '@angular/core';

@Component({
    selector: 'history-page',
    template: `
    <h2>Calculation History</h2>
    <h5>These are the last {{calculationHistory.length}} calculations</h5>
    <button class="returnToCalcButton" (click)="handleButtonClick()">Return to Calculator</button>
    <table>
        @for(calc of calculationHistory; track calc.id){
            
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
export class HistoryPage implements OnInit{

    calculationHistory: any[] = [];
    constructor(private api: Api, private cd: ChangeDetectorRef) {}
    ngOnInit() {
        this.loadHistory();
    }

    loadHistory(){
        //Api call for most recent data
        this.api.getHistory(0,5).subscribe(data =>{
            console.log("Fetching History:", data);
            //Goes through each record and rename the object and save to calculation history
            this.calculationHistory = data.calculations.map ((calc: any) => ({
                id: calc.id,
                first: calc.num1,
                operator: calc.operation,
                second: calc.num2,
                solution: calc.result
            }));
            this.cd.detectChanges();
        });
    }

    returnToCalculatorButtonClickEvent = output<string>();
    handleButtonClick(){
        this.returnToCalculatorButtonClickEvent.emit('');
    }
}

