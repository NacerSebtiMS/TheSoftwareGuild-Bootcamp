import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactRoutingModule } from './contact-routing.module';
import { ContactHomeComponent } from './contact-home/contact-home.component';


@NgModule({
  declarations: [ContactHomeComponent],
  imports: [
    CommonModule,
    ContactRoutingModule
  ]
})
export class ContactModule { }
