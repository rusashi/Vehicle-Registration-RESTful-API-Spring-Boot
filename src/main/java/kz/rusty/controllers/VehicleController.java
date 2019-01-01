package kz.rusty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.rusty.exception.VehicleServiceClientException;
import kz.rusty.model.Vehicle;
import kz.rusty.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	private VehicleService vehicleService;
	
	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	
	@GetMapping
	public ResponseEntity<Iterable<Vehicle>> findAllVehicles() {		
		return ResponseEntity.ok(vehicleService.findAll());
	}
	
	@GetMapping("/{vehicleId}")
	public ResponseEntity<?> findVehicleById(@PathVariable Long vehicleId) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(vehicleService.findById(vehicleId));
		} catch (VehicleServiceClientException e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return response;
	}

}
