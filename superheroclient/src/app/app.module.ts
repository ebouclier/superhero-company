import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { SuperheroListComponent } from './superhero-list/superhero-list.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {MatToolbarModule} from "@angular/material";


@NgModule({
  declarations: [
    AppComponent,
    SuperheroListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
