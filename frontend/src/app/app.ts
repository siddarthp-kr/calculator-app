import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalculatorPage } from './Components/CalculatorPage';
import { HistoryPage } from './Components/HistoryPage';

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
    <history-page/>
  }
  `,
  imports: [CalculatorPage, HistoryPage],
  styleUrl: './global_styles.css'
})
export class App {
  protected readonly title = signal('frontend');

  calculationValue = '';
  currentPageIsCalculator = true;

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
}
