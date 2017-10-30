import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { StompService } from 'ng2-stomp-service';
import { Message } from '@stomp/stompjs';

@Component({
  selector: 'app-web-socket-component',
  templateUrl: './web-socket-component.component.html',
  styleUrls: ['./web-socket-component.component.css']
})
export class WebSocketComponentComponent implements OnInit {

  @Input() sendData : string;

  private subscription : any;
  private message : string;

  //response 
public response = (data) => {
  console.log(data)
}

  constructor(stomp: StompService) {
    
     //configuration 
     stomp.configure({
       host:'http://localhost:8080/websocket',
       debug:true,
       queue:{'init':false}
     });
     
     //start connection 
     stomp.startConnect().then(() => {
       stomp.done('init');
       console.log('connected');
       
       //subscribe 
       this.subscription = stomp.subscribe('app1', function(msg){
          console.log(msg);
          WebSocketComponentComponent.prototype.message = JSON.stringify(msg);
       });
       
       //send data 
       stomp.send('app1',{"name":this.sendData});
       
       //unsubscribe 
       // this.subscription.unsubscribe();
       
       //disconnect 
       // stomp.disconnect().then(() => {
       //   console.log( 'Connection closed' )
       // })
       
     });
    
    
   }

  ngOnInit() {
  }

}
