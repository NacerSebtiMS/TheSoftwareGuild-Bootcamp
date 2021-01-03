import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServicesRoutingModule } from './services-routing.module';
import { ServicesHomeComponent } from './services-home/services-home.component';
import { HighlightDirective } from './services-home/highlight.directive';


@NgModule({
  declarations: [ServicesHomeComponent, HighlightDirective],
  imports: [
    CommonModule,
    ServicesRoutingModule
  ]
})
export class ServicesModule { }
