package kz.rusty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kz.rusty.Repository.VehicleRepository;
import kz.rusty.model.Vehicle;

@SpringBootApplication
@RestController
public class VehicleRegistrationResTfulApiApplication {
	
	@Autowired
	VehicleRepository repository;
	
	@RequestMapping(path="/vehicles", method=RequestMethod.GET)
	public Collection<Vehicle> vehiclesRepo() {
		return repository.findAll();		
	}	
	

	public static void main(String[] args) {
		SpringApplication.run(VehicleRegistrationResTfulApiApplication.class, args);
	}

}

