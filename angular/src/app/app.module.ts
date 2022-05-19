import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonListComponent } from './component/person-list/person-list.component';
import { FormsModule } from '@angular/forms';
import { PersonFormComponent } from './component/person-form/person-form.component';

@NgModule({
  declarations: [AppComponent, PersonListComponent, PersonFormComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
