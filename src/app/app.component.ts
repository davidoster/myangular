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
  cars?: Car[]

  ngOnInit() {
    this.colorOfACar.color = "Blue";
    this.justACar = "";
    this.cars = this.dummyCars();
  }

  thisIsAMethod(): string {
    return "Some String";
  }

  showTitle(event: any): any {
    console.log(event);
    this.changedInput = event.path[0].value;
    return this.changedInput;
  }

  dummyCars(): Car[] {
    let car1 = new Car();
    car1.color = "Blue";
    car1.price = 100;
    car1.name = "Blue 100";

    let car2 = new Car();
    car2.color = "Blue";
    car2.price = 100;
    car2.name = "Blue 100";

    let car3 = new Car();
    car3.color = "Blue";
    car3.price = 100;
    car3.name = "Blue 100";

    let cars = [];
    cars.push(car1, car2, car3);
    console.log(cars[0].name);
    return cars;
  }
  
}
