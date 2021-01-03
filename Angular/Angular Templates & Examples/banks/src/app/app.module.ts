import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BanksComponent } from './banks/banks.component';
import { BankDetailComponent } from './bank-detail/bank-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    BanksComponent,
    BankDetailComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
