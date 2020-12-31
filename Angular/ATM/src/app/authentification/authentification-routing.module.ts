import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthentificationHomeComponent } from './authentification-home/authentification-home.component';

const routes: Routes = [
  { path: 'authentification', component: AuthentificationHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthentificationRoutingModule { }
