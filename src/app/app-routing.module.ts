import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarsListComponent } from './components/cars-list/cars-list.component';
import { CarNewComponent } from './components/car-new/car-new.component';

const routes: Routes = [ 
  { path: '', component: CarsListComponent},
  { path: 'index', component: CarsListComponent },
  { path: 'new', component:  CarNewComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
