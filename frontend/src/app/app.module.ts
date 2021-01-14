import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FrameModule } from './frame/frame.module';
import { TaskModule } from './task/task.module';
import { AppRoutingModule } from './app.routing.module';
import { ErrorsModule } from './errors/errors.module';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FrameModule,
    TaskModule,
    AppRoutingModule,
    ErrorsModule,
    HttpClientModule        
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
