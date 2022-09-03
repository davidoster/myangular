import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarService } from 'src/app/services/car.service';
import { CarsListComponent } from '../cars-list/cars-list.component';


@Component({
  selector: 'app-car-new',
  templateUrl: './car-new.component.html',
  styleUrls: ['./car-new.component.css']
})
export class CarNewComponent implements OnInit {
  carInstance: Car = new Car()
  
  constructor(private carService: CarService) { }

  ngOnInit(): void {  
  }

  onSubmit(f: NgForm) {
    this.carService.create(this.carInstance).subscribe({
      next: (res) => {
        console.log(res);
      },
      error: (e) => console.error(e)
    });
    console.log(this.carInstance.name, this.carInstance.color, this.carInstance.price);
    console.log(f.valid);  // false
  }

}
