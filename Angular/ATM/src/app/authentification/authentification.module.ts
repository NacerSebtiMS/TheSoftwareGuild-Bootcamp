import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthentificationRoutingModule } from './authentification-routing.module';
import { AuthentificationHomeComponent } from './authentification-home/authentification-home.component';


@NgModule({
  declarations: [AuthentificationHomeComponent],
  imports: [
    CommonModule,
    AuthentificationRoutingModule
  ]
})
export class AuthentificationModule { }
