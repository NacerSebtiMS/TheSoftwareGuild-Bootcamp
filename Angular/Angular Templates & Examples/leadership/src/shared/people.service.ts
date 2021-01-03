import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  constructor() { }

  getPeople(): Observable<any>{
    let peopleArray = [{
      firstName: 'James',
      lastName: 'Dimon',
      jobTitle: 'Chairman of the Board and Chief Executive Officer'
    },{
      firstName: 'Lori',
      lastName: 'Beer',
      jobTitle: 'Global Chief Information Officer'
    },{
      firstName: 'Thasunda',
      lastName: 'Duckett',
      jobTitle: 'CEO, Consumer Banking'
    },{
    firstName: 'Mary',
    lastName: 'Erdoes',
    jobTitle: 'Asset & Wealth Management CEO'
  },{
    firstName: 'Carlos',
      lastName: 'Hernandez',
      jobTitle: 'Executive Chair of Investment & Corporate Banking'
  }
  ];
  return of(peopleArray);
  }
}
