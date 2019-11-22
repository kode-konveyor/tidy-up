package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;

public class CreateWorkRequestValidationHelper { // NOPMD

	public static void checkAddress(final CreateWorkRequestDTO createWorkRequestDTO) {
		final String address = createWorkRequestDTO.getAddress().getAddress();
		if (address == null || address.isEmpty())
			throw new ValidationException(CreateConstants.INVALID_ADDRESS);
	}

	public static void checkCity(final CreateWorkRequestDTO createWorkRequestDTO) {
		final String city = createWorkRequestDTO.getAddress().getCity();
		if (city == null || city.isEmpty())
			throw new ValidationException(CreateConstants.INVALID_CITY);
	}

	public static void checkCountry(final CreateWorkRequestDTO createWorkRequestDTO) {
		final String country = createWorkRequestDTO.getAddress().getCountry();
		if (country == null || country.isEmpty())
			throw new ValidationException(CreateConstants.INVALID_COUNTRY);
	}

}
