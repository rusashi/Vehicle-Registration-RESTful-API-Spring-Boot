package kz.rusty.exception;

public class VehicleServiceClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehicleServiceClientException(String errorMessage) {
		super(errorMessage);
	}

}
