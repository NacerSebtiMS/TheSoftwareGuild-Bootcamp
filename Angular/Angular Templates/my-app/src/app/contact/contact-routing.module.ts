import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContactHomeComponent } from './contact-home/contact-home.component';

const routes: Routes = [
  { path: 'contact', component: ContactHomeComponent}
 ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContactRoutingModule { }
