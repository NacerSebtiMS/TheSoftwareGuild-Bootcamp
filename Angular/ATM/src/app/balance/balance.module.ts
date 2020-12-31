import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BalanceRoutingModule } from './balance-routing.module';
import { BalanceHomeComponent } from './balance-home/balance-home.component';


@NgModule({
  declarations: [BalanceHomeComponent],
  imports: [
    CommonModule,
    BalanceRoutingModule
  ]
})
export class BalanceModule { }
