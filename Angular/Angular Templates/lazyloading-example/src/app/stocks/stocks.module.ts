import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StocksRoutingModule } from './stocks-routing.module';
import { StocksComponent } from './stocks.component';


@NgModule({
  declarations: [StocksComponent],
  imports: [
    CommonModule,
    StocksRoutingModule
  ]
})
export class StocksModule { }
