package kz.rusty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import kz.rusty.Repository.VehicleRepository;
import kz.rusty.exception.VehicleServiceClientException;
import kz.rusty.model.Vehicle;

public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleServiceImpl(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Vehicle findById(Long id) {
		if (id == null) {
			throw new VehicleServiceClientException("Null argument was passed");
		}
		Optional<Vehicle> vehicOptional = vehicleRepository.findById(id);
		if (!vehicOptional.isPresent()) {
			throw new VehicleServiceClientException("Vehicle with number "+id+" does not exist");
		}
		return vehicOptional.get();
	}
		
}
