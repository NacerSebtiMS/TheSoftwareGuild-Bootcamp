import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { 
    path: 'stocks', 
    loadChildren: () => import('./stocks/stocks.module').then(m => m.StocksModule) 
  }, 
  { 
    path: 'bonds',
    loadChildren: () => import('./bonds/bonds.module').then(m => m.BondsModule) 
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
