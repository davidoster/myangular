package org.peoplecert.cars.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.peoplecert.cars.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByNameContaining(String name);
}