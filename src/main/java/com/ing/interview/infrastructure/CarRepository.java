package com.ing.interview.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.interview.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}