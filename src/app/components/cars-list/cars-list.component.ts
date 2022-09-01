import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';

@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})
export class CarsListComponent implements OnInit {
  cars?: Car[]
  constructor() { }

  ngOnInit(): void {
    this.cars = this.dummyCars();
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
