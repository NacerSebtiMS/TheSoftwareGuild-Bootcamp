import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CalculatorHomeComponent } from './calculator-home/calculator-home.component';

const routes: Routes = [
  { path: 'calculator', component: CalculatorHomeComponent},
  { path: '' , redirectTo:'/calculator', pathMatch:'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CalculatorRoutingModule { }
