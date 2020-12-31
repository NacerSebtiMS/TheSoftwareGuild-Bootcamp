import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BalanceHomeComponent } from './balance-home/balance-home.component';

const routes: Routes = [
  { path: 'balance', component: BalanceHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BalanceRoutingModule { }
