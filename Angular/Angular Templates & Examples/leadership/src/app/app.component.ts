import { Component } from '@angular/core';
import { PeopleService } from 'src/shared/people.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'leadership';

  peopleArray: any;
  
  constructor(private peopleService: PeopleService) { }

  getPeople(){
    this.peopleService.getPeople().subscribe(people => {
        this.peopleArray = people
    });
  }

  ngOnInit() {
    this.getPeople();
  }
}
