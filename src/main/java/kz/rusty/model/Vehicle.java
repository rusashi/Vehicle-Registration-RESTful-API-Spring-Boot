package kz.rusty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="make")
	private String make;
	@Column(name="model")
	private String model;
	@Column(name="colour")
	private String colour;
	@Column(name="engine_size")
	private double engineSize;
	
	
	public Vehicle() {
		super();
	}

	public Vehicle(Long id, String make, String model, String colour, double engineSize) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.engineSize = engineSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}		
}

