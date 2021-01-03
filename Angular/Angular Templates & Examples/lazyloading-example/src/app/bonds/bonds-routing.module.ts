import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BondsComponent } from './bonds.component';

const routes: Routes = [{ path: '', component: BondsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BondsRoutingModule { }
