package com.oneoonecode.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Car save(Car car){
       return carRepository.save(car);
    }

    public List<Car> findAll(){

        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}
