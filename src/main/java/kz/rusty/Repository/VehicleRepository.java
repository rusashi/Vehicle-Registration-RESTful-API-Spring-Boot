package kz.rusty.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.rusty.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
