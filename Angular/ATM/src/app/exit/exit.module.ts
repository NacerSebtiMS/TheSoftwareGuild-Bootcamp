import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExitRoutingModule } from './exit-routing.module';
import { ExitHomeComponent } from './exit-home/exit-home.component';


@NgModule({
  declarations: [ExitHomeComponent],
  imports: [
    CommonModule,
    ExitRoutingModule
  ]
})
export class ExitModule { }
