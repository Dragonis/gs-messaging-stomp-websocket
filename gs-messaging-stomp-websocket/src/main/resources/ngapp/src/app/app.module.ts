import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { StompService } from 'ng2-stomp-service';
import { Message } from '@stomp/stompjs';
import { WebSocketComponentComponent } from './web-socket-component/web-socket-component.component';

@NgModule({
  declarations: [
    AppComponent,
    WebSocketComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [StompService],
  bootstrap: [AppComponent]
})
export class AppModule { }
