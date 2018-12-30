package kz.rusty.service;

import org.junit.Test;

import kz.rusty.Repository.VehicleRepository;
import kz.rusty.model.Vehicle;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class VehicleServiceImplTest {

	@Test
	public void lookupExistingVehicle_shouldReturnAnObject() {
		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
		Optional<Vehicle> vehicle =  Optional.of(new Vehicle());
		when(vehicleRepository.findById(anyLong())).thenReturn(vehicle);
		
		VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
		Optional<Vehicle> returnValue = vehicleService.findById(new Long(111));
		assertNotNull(returnValue.get());			
	}

}
