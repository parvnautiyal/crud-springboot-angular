import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/common/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css'],
})
export class PersonFormComponent implements OnInit {
  person!: Person;

  constructor(private personService: PersonService) {
    this.person = new Person();
  }

  ngOnInit(): void {}

  onSubmit() {
    this.personService.addPerson(this.person).subscribe((data) => {
      this.person = data;
      location.reload();
    });
  }
}
