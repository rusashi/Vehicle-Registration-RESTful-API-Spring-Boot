package kz.rusty.service;

import org.h2.util.New;
import org.junit.Test;

import kz.rusty.model.Vehicle;
import kz.rusty.repository.VehicleRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VehicleServiceImplTest {

	////// findById //////
	@Test
	public void lookupExistingVehicle_shouldReturnObject() {
		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
		when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(new Vehicle()));
		
		VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
		Vehicle vehicle = vehicleService.findById(new Long(111));
		assertNotNull(vehicle);			
	}
	
	@Test
	public void lookupNonExistingVehicle_shouldThrowException() {
		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
		when(vehicleRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
		try {
			vehicleService.findById(new Long(111));
			fail("Exception should have been thrown");
		} catch (Exception e) {
			assertEquals("Vehicle with number 111 does not exist", e.getMessage());
		}
	}
	
	@Test
	public void lookupVehicleByNullId_shouldThrowException() {
		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
		VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
		
		try {
			vehicleService.findById(null);
		} catch (Exception e) {
			assertEquals("Null argument was passed", e.getMessage());
		}
		
	}
	
	////findAll //////
	
	@Test
	public void lookupAllVehicles_shouldReturnIterable() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
		when(vehicleRepository.findAll()).thenReturn(vehicles);
		
		VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
		Iterable<Vehicle> vehiclesIterable = vehicleService.findAll();
		
		assertEquals(vehicles, vehiclesIterable);
		verify(vehicleRepository, times(1)).findAll();
	}

}
