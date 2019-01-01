package kz.rusty.service;

import kz.rusty.model.Vehicle;

public interface VehicleService {

	Vehicle findById(Long id);

	Iterable<Vehicle> findAll();

}
