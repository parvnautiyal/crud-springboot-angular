import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/common/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css'],
})
export class PersonListComponent implements OnInit {
  persons!: Person[];

  constructor(private personService: PersonService) {}

  ngOnInit(): void {
    this.getPersons();
  }

  getPersons() {
    this.personService.getPersonList().subscribe((data) => {
      this.persons = data;
    });
  }

  deletePersons(person: Person) {
    this.personService.deletePerson(person.id).subscribe((response) => {
      this.persons = this.persons.filter((item) => item.id !== person.id);
    });
  }
}
