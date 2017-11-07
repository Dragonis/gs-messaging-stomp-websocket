import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { StompService } from 'ng2-stomp-service';
import { Message } from '@stomp/stompjs';

@Component({
  selector: 'app-web-socket-component',
  templateUrl: './web-socket-component.component.html',
  styleUrls: ['./web-socket-component.component.css']
})
export class WebSocketComponentComponent implements OnInit {


  @Input() nrApp: string;
  @Input() sendData: string;

  private stomp: StompService;

  private subscription: any;
  private message: string;

    // response
  public response = (data) => {
    console.log(data);
  }

  constructor(stomp: StompService) {
     // configuration
     stomp.configure({
       host: 'http://localhost:8085/gs-guide-websocket/',
       debug: true,
       queue: {'init': true}
     });

     this.stomp = stomp;
    this.setSubscription();

   }


setSubscription() {
  // start connection
  this.stomp.startConnect().then(() => {
    this.stomp.done('init');
    console.log('connected');

    // subscribe
    this.subscription = this.stomp.subscribe('/topic/greetings', function(msg){
       console.log(msg);
       WebSocketComponentComponent.prototype.message = JSON.stringify(msg);
    });

    this.sendMessage(this.nrApp, this.sendData);

    // unsubscribe
    // this.subscription.unsubscribe();

    // disconnect
    // this.stomp.disconnect().then(() => {
    //   console.log( 'Connection closed' )
    // })

  });
}

sendMessage(nrApp: string, sendData: string) {
   // send data
   this.stomp.send(nrApp, {'content': sendData});

}

  ngOnInit() {
  }

}
