package kz.rusty.service;

import java.util.Optional;

import kz.rusty.model.Vehicle;

public interface VehicleService {

	Optional<Vehicle> findById(Long id);

}
