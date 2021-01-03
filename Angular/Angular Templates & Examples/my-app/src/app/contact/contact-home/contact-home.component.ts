import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-home',
  templateUrl: './contact-home.component.html',
  styleUrls: ['./contact-home.component.css']
})
export class ContactHomeComponent implements OnInit {
  isUnchanged = true;

  onCancel(event?: KeyboardEvent) {
    const evtMsg = event ? ' Event target is ' + (event.target as HTMLElement).textContent : '';
    alert('Cancelled.' + evtMsg);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
