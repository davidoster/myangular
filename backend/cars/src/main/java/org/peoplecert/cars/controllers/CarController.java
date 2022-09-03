package org.peoplecert.cars.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.peoplecert.cars.models.Car;
import org.peoplecert.cars.repositories.CarRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	CarRepository CarRepository;

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars(@RequestParam(required = false) String title) {
		try {
			List<Car> Cars = new ArrayList<Car>();

			if (title == null)
				CarRepository.findAll().forEach(Cars::add);
			else
				CarRepository.findByNameContaining(title).forEach(Cars::add);

			if (Cars.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Cars, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
		Optional<Car> CarData = CarRepository.findById(id);

		if (CarData.isPresent()) {
			return new ResponseEntity<>(CarData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/cars")
	public ResponseEntity<Car> createCar(@RequestBody Car Car) {
		try {
			Car _Car = CarRepository
					.save(new Car(Car.getName(), Car.getColor(), Car.getPrice()));
			return new ResponseEntity<>(_Car, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") long id, @RequestBody Car Car) {
		Optional<Car> CarData = CarRepository.findById(id);

		if (CarData.isPresent()) {
			Car _Car = CarData.get();
			_Car.setName(Car.getName());
			_Car.setColor(Car.getColor());
			_Car.setPrice(Car.getPrice());
			return new ResponseEntity<>(CarRepository.save(_Car), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cars/{id}")
	public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") long id) {
		try {
			CarRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/cars")
	public ResponseEntity<HttpStatus> deleteAllCars() {
		try {
			CarRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

}
