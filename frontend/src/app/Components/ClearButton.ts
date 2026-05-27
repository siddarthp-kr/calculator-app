import { Component } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'clear-button',
  template: ` <button class="btn" (click)="handleButtonClick()">CLEAR</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class ClearButton {
  clearButtonClickEvent = output<string>();
  handleButtonClick() {
    this.clearButtonClickEvent.emit('');
  }
}