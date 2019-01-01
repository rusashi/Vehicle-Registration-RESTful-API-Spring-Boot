package kz.rusty.repository;

import org.springframework.data.repository.CrudRepository;

import kz.rusty.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
}
