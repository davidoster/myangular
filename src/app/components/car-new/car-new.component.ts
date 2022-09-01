import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarsListComponent } from '../cars-list/cars-list.component';


@Component({
  selector: 'app-car-new',
  templateUrl: './car-new.component.html',
  styleUrls: ['./car-new.component.css']
})
export class CarNewComponent implements OnInit {
  carInstance: Car = new Car()
  constructor() { }

  ngOnInit(): void {
    
  }

  onSubmit(f: NgForm) {
    console.log(this.carInstance.name, this.carInstance.color, this.carInstance.price);
    console.log(f.valid);  // false
  }

}
