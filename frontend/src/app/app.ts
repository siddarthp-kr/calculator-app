import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalculatorPage } from './Components/CalculatorPage';
import { HistoryPage } from './Components/HistoryPage';
import { Api } from './services/api';
import { ChangeDetectorRef } from '@angular/core';



@Component({
  selector: 'app-root',
  standalone: true,
  template: `
  @if(currentPageIsCalculator){
    <calculator-page 
      [displayValue] = "calculationValue" 
      (numberClickEvent) = "updateCalculationValue($event)" 
      (clearButtonClickEvent)="clearScreen()"
      (backspaceButtonClickEvent)="backspaceScreen()"
      (closeButtonClickEvent)="closeApp()"
      (historyButtonClickEvent)="openHistoryPage()"
      (equalsButtonClickEvent)="performCalculationInBackend()"
      />
  } @else {
    <history-page (returnToCalculatorButtonClickEvent) = "this.returnToCalculator()"/>
  }
  `,
  imports: [CalculatorPage, HistoryPage],
  styleUrl: './global_styles.css'
})
export class App {
  protected readonly title = signal('frontend');

  calculationValue = '';
  currentPageIsCalculator = true;

  private api = inject(Api)

  constructor(private cd: ChangeDetectorRef){}

  updateCalculationValue(item: string) {
    this.calculationValue += <string>item;
  }

  clearScreen(){
    this.calculationValue = '';
  }

  backspaceScreen(){
    this.calculationValue = this.calculationValue.substring(0, this.calculationValue.length - 1);
  }

  closeApp(){
    window.location.href = 'about:blank';
  }

  openHistoryPage(){
    this.currentPageIsCalculator = false;
  }

  returnToCalculator(){
    this.currentPageIsCalculator = true;
  }

  async performCalculationInBackend(){
    let solution = await this.api.sendCalculationToBackend(this.calculationValue);
    this.calculationValue = solution//JSON.parse(solution).solution;
    console.log(solution)
    console.log(this.calculationValue)
    this.cd.detectChanges()
  }
}
