import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeModule } from './home/home.module';
import { AccountModule } from './account/account.module';
import { AuthentificationModule } from './authentification/authentification.module';
import { BalanceModule } from './balance/balance.module';
import { ExitModule } from './exit/exit.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    AccountModule,
    AuthentificationModule,
    BalanceModule,
    ExitModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
