import { Component } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'equals-button',
  template: ` <button class="btn" (click)="handleButtonClick()">=</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class EqualsButton {
  equalsButtonClickEvent = output<string>();
  handleButtonClick() {
    this.equalsButtonClickEvent.emit('');
  }
}
