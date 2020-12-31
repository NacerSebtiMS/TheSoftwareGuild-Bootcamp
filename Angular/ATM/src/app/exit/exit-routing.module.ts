import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ExitHomeComponent } from './exit-home/exit-home.component';

const routes: Routes = [
  { path: 'exit', component: ExitHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExitRoutingModule { }
