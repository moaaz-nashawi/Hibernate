package com.oneoonecode.Hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(HibernateApplication.class, args);
	    CarService carService =	configurableApplicationContext.getBean(CarService.class);

		carService.save(new Car(1L,"X5",260));
		carService.save(new Car(2L,"X6",360));
		carService.save(new Car(3L,"X7",500));

	List<Car> carList =	carService.findAll();

		for (Car car: carList
			 ) {
			System.out.println(car.getModel());

		}

		Optional<Car> carToUpdate = carService.findById(2L);

		if(carToUpdate.isPresent()){
			carToUpdate.get().setModel("X9");
			carService.save(carToUpdate.get());
		}

		 carList =	carService.findAll();

		for (Car car: carList
		) {
			System.out.println(car.getModel());

		}

		carService.deleteById(2L);


		carList =	carService.findAll();

		for (Car car: carList
		) {
			System.out.println(car.getModel());

		}


	}



}
