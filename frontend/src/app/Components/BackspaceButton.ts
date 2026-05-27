import { Component } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'backspace-button',
  template: ` <button class="btn" (click)="handleButtonClick()">BACKSPACE</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class BackspaceButton {
  backspaceButtonClickEvent = output<string>();
  handleButtonClick() {
    this.backspaceButtonClickEvent.emit('');
  }
}