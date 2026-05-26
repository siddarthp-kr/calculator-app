import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GridLayout } from './GridLayout';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `<grid-layout 
    displayValue= {{calculationValue}} 
    (numberClickEvent) = "this.updateCalculationValue($event)" 
    (clearButtonClickEvent)="this.clearScreen()"
    (backspaceButtonClickEvent)="this.backspaceScreen()"
    />`,
  imports: [GridLayout],
  styleUrl: './global_styles.css'
})
export class App {
  protected readonly title = signal('frontend');

    calculationValue = '';

  updateCalculationValue(item: string) {
    this.calculationValue += <string>item;
  }

  clearScreen(){
    this.calculationValue = '';
  }

  backspaceScreen(){
    this.calculationValue = this.calculationValue.substring(0, this.calculationValue.length - 1);
    //window.location.href = 'about:blank';

  }
}
