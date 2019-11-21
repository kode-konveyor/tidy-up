package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestDTO;

public class CreateWorkRequestController {

	public static void call(final String address, final String city, final String country, final String workType,
			final String description) {

		CheckInputs(address, city, country, workType, description);

	}

	private WorkRequestDTO createWorkRequest() {

		return new WorkRequestDTO();
	}

	public static void CheckInputs(final String address, final String city, final String country, final String workType,
			final String description) {

		if (address.length() > 120)
			throw new ValidationException(WorkRequestConstants.ADDRESS_LENGHT_EXCEEDED);

	}

}
