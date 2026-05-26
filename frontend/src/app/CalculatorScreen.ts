import { Component } from '@angular/core';
import { input } from '@angular/core';

@Component({
  selector: 'calculator-screen',
  template: ` <input type="text" id="calculation" name="calculation" value = {{screenValue()}} placeholder="0" readonly> `,
  standalone: true,
  styles: `
    input {
      width: 608px;
      height: 60px;
      font-size: 50px;
      color: black;
    }
  `
})
export class CalculatorScreen {
  screenValue = input<string>();
}
