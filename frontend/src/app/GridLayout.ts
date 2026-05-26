import { Component } from '@angular/core';
import { input } from '@angular/core';
import { output } from '@angular/core';
import { NumberButton } from './NumberButton';
import { CalculatorScreen } from './CalculatorScreen';
import { ClearButton } from './ClearButton';
import { BackspaceButton } from './BackspaceButton';


@Component({
  selector: 'grid-layout',
  standalone: true,
  imports: [NumberButton, ClearButton, BackspaceButton, CalculatorScreen],
  template: `
  <div class = 'grid'>
    <div class='header'>
      <calculator-screen screenValue={{displayValue()}}/>
    </div>

    <number-button numValue=HISTORY/>
    <number-button numValue=CLOSE/>
    <clear-button (clearButtonClickEvent)="clearButtonClickEvent.emit('')" />
    <backspace-button (backspaceButtonClickEvent)="backspaceButtonClickEvent.emit('')"/>

    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=7/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=8/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=9/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=+/>
    
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=4/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=5/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=6/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=-/>

    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=1/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=2/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=3/>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=*/>

    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=./>
    <number-button (numberClickEvent)="numberClickEvent.emit($event)" numValue=0/>
    <number-button numValue='='/>
    <number-button numValue='/'>
  <div>
  `,
  styleUrl: "global_styles.css"
})
export class GridLayout {
  displayValue = input<string>();
  numberClickEvent = output<string>();
  clearButtonClickEvent = output<string>();
  backspaceButtonClickEvent = output<string>();
}
