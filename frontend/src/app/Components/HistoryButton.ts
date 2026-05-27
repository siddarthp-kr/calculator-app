import { Component } from '@angular/core';
import { output } from '@angular/core';

@Component({
  selector: 'history-button',
  template: ` <button class="btn" (click)="handleButtonClick()">HISTORY</button> `,
  styleUrl: "global_styles.css",
  standalone: true,
})
export class HistoryButton {
  historyButtonClickEvent = output<string>();
  handleButtonClick() {
    this.historyButtonClickEvent.emit('');
  }
}