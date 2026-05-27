import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalculatorPage } from './Components/CalculatorPage';
import { HistoryPage } from './Components/HistoryPage';
import { Api } from './services/api';



@Component({
  selector: 'app-root',
  standalone: true,
  template: `
  @if(currentPageIsCalculator){
    <calculator-page 
      displayValue= {{calculationValue}} 
      (numberClickEvent) = "this.updateCalculationValue($event)" 
      (clearButtonClickEvent)="this.clearScreen()"
      (backspaceButtonClickEvent)="this.backspaceScreen()"
      (closeButtonClickEvent)="this.closeApp()"
      (historyButtonClickEvent)="this.openHistoryPage()"
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

  updateCalculationValue(item: string) {
    this.calculationValue += <string>item;
  }

  clearScreen(){
    this.calculationValue = '';
    this.api.testFunction()
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
}
