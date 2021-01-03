import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BondsRoutingModule } from './bonds-routing.module';
import { BondsComponent } from './bonds.component';


@NgModule({
  declarations: [BondsComponent],
  imports: [
    CommonModule,
    BondsRoutingModule
  ]
})
export class BondsModule { }
