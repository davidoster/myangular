import { Component } from '@angular/core';
import { Car } from './models/car';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myangular';
  justACar = JSON.stringify(new Car());
  colorOfACar = new Car();
  changedInput?: string

  ngOnInit() {
    this.colorOfACar.color = "Blue";
    this.justACar = "";
  }

  thisIsAMethod(): string {
    return "Some String";
  }

  showTitle(event: any): any {
    console.log(event);
    this.changedInput = event.path[0].value;
    return this.changedInput;
  }
  
}
