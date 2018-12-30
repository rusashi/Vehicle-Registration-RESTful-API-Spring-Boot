package kz.rusty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import kz.rusty.Repository.VehicleRepository;
import kz.rusty.model.Vehicle;

public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleServiceImpl(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Optional<Vehicle> findById(Long id) {
		return vehicleRepository.findById(id);
	}
		
}
