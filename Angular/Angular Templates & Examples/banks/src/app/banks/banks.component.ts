import { Component, OnInit } from '@angular/core';
import { Bank } from '../bank';
import { BANKS } from '../banks';

@Component({
  selector: 'app-banks',
  templateUrl: './banks.component.html',
  styleUrls: ['./banks.component.css']
})
export class BanksComponent implements OnInit {
  banks = BANKS;
  selectedBank: Bank;

  displayBanks = true;
  displayDetails = false;

  constructor() { }

  onSelect(bank: Bank): void {
    this.selectedBank = bank;
    this.displayDetails = true;
    this.displayBanks = false;
  }

  onReturn(){
    this.displayDetails = false;
    this.displayBanks = true;
  }

  ngOnInit(): void {
  }

}
