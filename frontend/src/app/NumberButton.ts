import { Component } from '@angular/core';
import { input } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'number-button',
  template: ` <button class="btn" (click)="handleButtonClick()">{{numValue()}}</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class NumberButton {
  numValue = input<string>();
  numberClickEvent = output<string>();
  handleButtonClick() {
    this.numberClickEvent.emit(<string>this.numValue());
  }
}
