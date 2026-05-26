import { Component } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'close-button',
  template: ` <button class="btn" (click)="handleButtonClick()">CLOSE</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class CloseButton {
  closeButtonClickEvent = output<string>();
  handleButtonClick() {
    this.closeButtonClickEvent.emit('');
  }
}