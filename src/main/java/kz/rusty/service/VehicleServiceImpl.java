package kz.rusty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.rusty.exception.VehicleServiceClientException;
import kz.rusty.model.Vehicle;
import kz.rusty.repository.VehicleRepository;

@Service
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
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
		if (!vehicleOptional.isPresent()) {
			throw new VehicleServiceClientException("Vehicle with number "+id+" does not exist");
		}
		return vehicleOptional.get();
	}

	@Override
	public Iterable<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
		
}
