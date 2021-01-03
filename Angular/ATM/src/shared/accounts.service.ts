import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  constructor() { }

  getAccounts(): Observable<any>{
    let accountsArray = [
    {
      username : 'johndoe',
      pin : '1234',
      firstname : 'John',
      lastname : 'Doe',
      accounts : [
        {
          name : 'Checking account',
          balance : 5000
        },
        {
          name : 'Savings account',
          balance : 10000
        }
      ]
    },

    {
      username : 'janedoe',
      pin : '5678',
      firstname : 'Jane',
      lastname : 'Doe',
      accounts : [
        {
          name : 'Checking account',
          balance : 33333
        },
        {
          name : 'Savings account',
          balance : 999999
        }
      ]
    }
    ];
    return of(accountsArray);
  }
}
